package com.barclays.service;

import com.barclays.model.Work;

import java.util.List;

public interface WorkService {

    List<Work> findAll();

    Work findById(long id);
}
