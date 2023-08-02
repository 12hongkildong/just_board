package com.just_board.just_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.just_board.just_board.entity.testtable;
import com.just_board.just_board.service.test;

@RestController
public class TestController {
    
    @Autowired
    test service;
    
    @GetMapping("testall")
    public List<testtable> testall(){
        return service.getByListAll();
    }
}
