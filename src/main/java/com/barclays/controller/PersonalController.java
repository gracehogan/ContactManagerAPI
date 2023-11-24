package com.barclays.controller;

import com.barclays.model.Personal;
import com.barclays.service.PersonalService;
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
public class PersonalController {

    private final PersonalService personalService;

    @GetMapping("/personal")
    public List<Personal> getAllPersonalContacts(){
        log.debug("In the getAllPersonalContacts method");
        List<Personal> personalContacts = Collections.emptyList();
        personalContacts = personalService.findAll();
        return personalContacts;
    }

    @GetMapping("/personal/{id}")
    public Personal getPersonalContact(@PathVariable long id){
        log.debug("In the getPersonalContact method: " + id);
        return personalService.findById(id);
    }

}
