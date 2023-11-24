package com.barclays.service;

import com.barclays.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact findById(long id);
}
