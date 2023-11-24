package com.barclays.controller;

import com.barclays.model.Contact;
import com.barclays.service.ContactService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
        log.debug("In the getAllContacts method");
        List<Contact> contacts = Collections.emptyList();
        contacts = contactService.findAll();
        return contacts;
    }

    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable long id){
        log.debug("In the getContact method: " + id);
        return contactService.findById(id);
    }

}
