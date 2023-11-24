package com.barclays.controller;


import com.barclays.model.Personal;
import com.barclays.model.Work;
import com.barclays.service.WorkService;
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
public class WorkController {

    private final WorkService workService;

    @GetMapping("/work")
    public List<Work> getAllWorkContacts(){
        log.debug("In the getAllWorkContacts method");
        List<Work> workContacts = Collections.emptyList();
        workContacts = workService.findAll();
        return workContacts;
    }

    @GetMapping("/work/{id}")
    public Work getWorkContact(@PathVariable long id){
        log.debug("In the getWorkContact method: " + id);
        return workService.findById(id);
    }

}
