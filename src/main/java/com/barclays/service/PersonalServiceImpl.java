package com.barclays.service;

import com.barclays.model.Personal;
import com.barclays.repository.PersonalRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PersonalServiceImpl implements PersonalService{

    private final PersonalRepository personalRepository;
    @Override
    public List<Personal> findAll() {
        List<Personal> personalContacts = new ArrayList<>();
        Iterable<Personal> personalIterable = personalRepository.findAll();
        personalIterable.forEach(personalContacts::add);
        return personalContacts;
    }

    @Override
    public Personal findById(long id) {
        Optional<Personal> personalContact = personalRepository.findById(id);
        return personalContact.orElseGet(()-> new Personal());
    }
}
