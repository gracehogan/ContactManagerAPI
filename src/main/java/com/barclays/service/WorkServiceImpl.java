package com.barclays.service;

import com.barclays.model.Work;
import com.barclays.repository.WorkRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class WorkServiceImpl implements WorkService{

    private WorkRepository workRepository;
    @Override
    public List<Work> findAll() {
        List<Work> workContacts = new ArrayList<>();
        Iterable<Work> workIterable = workRepository.findAll();
        workIterable.forEach(workContacts::add);
        return workContacts;
    }

    @Override
    public Work findById(long id) {
        Optional<Work> workContact = workRepository.findById(id);
        return workContact.orElseGet(() -> new Work());
    }
}
