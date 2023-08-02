package com.just_board.just_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.just_board.just_board.entity.Article;
import com.just_board.just_board.repository.ArticleRepository;
import com.just_board.just_board.service.ArticleService;

@RestController
public class BoardController {
    
    @Autowired
    private ArticleService service;

    @Autowired
    private ArticleRepository repository;


    @GetMapping("listall")
    public List<Article> listAll(){
        System.out.println("아따따뚜겐");
        System.out.println();
        System.out.println();
        return service.getByListAll();
        // return service.getByListAllDesc(0,20);
    }

    @GetMapping("any")
    public String any(){
        System.out.println("아무아무");
        // System.out.println(repository.findAll());
        return "아무거나 말해줘";
    }


}
