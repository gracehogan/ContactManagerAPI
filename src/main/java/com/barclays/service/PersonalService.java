package com.barclays.service;

import com.barclays.model.Personal;

import java.util.List;

public interface PersonalService {

    List<Personal> findAll();

    Personal findById(long id);
}
