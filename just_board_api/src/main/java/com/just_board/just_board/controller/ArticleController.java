package com.just_board.just_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.repository.Article2Repository;
import com.just_board.just_board.service.ArticleService2;

@RestController
public class ArticleController {
    
    @Autowired
    private ArticleService2 service;

    @Autowired
    private Article2Repository repository;


    @GetMapping("listall3")
    public List<Article2> listAll(){
        System.out.println("int4 / int8 / bigserial을 잘 불러오는 지 테스트");
        System.out.println();
        System.out.println();
        return service.getByListAll();
        // return service.getByListAllDesc(0,20);
    }

    @GetMapping("any3")
    public String any(){
        System.out.println("아무아무");
        // System.out.println(repository.findAll());
        return "아무거나 말해줘2";
    }


}
