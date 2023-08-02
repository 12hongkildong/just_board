package com.just_board.just_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.just_board.just_board.entity.testtable;
import com.just_board.just_board.repository.TestRepository;

@Service
public class DefaultTest implements test {

    @Autowired
    TestRepository repository;

    @Override
    public List<testtable> getByListAll() {
        
        return repository.findAll();
    }
    
}
