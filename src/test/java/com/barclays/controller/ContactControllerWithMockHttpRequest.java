package com.barclays.controller;

import com.barclays.model.Address;
import com.barclays.model.Contact;
import com.barclays.model.PhoneNumber;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class ContactControllerWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void testGettingContacts() throws Exception {
        int expectedLength = 2;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Contact[] contacts = mapper.readValue(contentAsString, Contact[].class);

        assertAll("Mock Http Request",
                () -> assertEquals(expectedLength, contacts.length),
                () -> assertEquals("Grace", contacts[0].getName()),
                () -> assertEquals("456 Street", contacts[1].getAddress().getLineOne())
        );

    }

    @Test
    void testCreateContact() throws Exception {
        Contact contact = new Contact();
        contact.setName("Bob");

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                        .content(mapper.writeValueAsString(contact))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        contact = mapper.readValue(contentAsString, Contact.class);


        assertEquals("Bob", contact.getName());
    }
}
