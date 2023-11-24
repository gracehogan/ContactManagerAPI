package com.barclays.service;

import com.barclays.model.Contact;
import com.barclays.repository.ContactRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        Iterable<Contact> contactIterable = contactRepository.findAll();
        contactIterable.forEach(contacts::add);
        return contacts;
    }

    @Override
    public Contact findById(long id) {
        Optional<Contact> personalContact = contactRepository.findById(id);
        return personalContact.orElseGet(()-> new Contact());
    }

    @Override
    public Contact save(Contact c) {
        return contactRepository.save(c);
    }
}
