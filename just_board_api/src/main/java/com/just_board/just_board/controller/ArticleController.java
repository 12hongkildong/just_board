package com.just_board.just_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.repository.Article2Repository;
import com.just_board.just_board.service.ArticleService2;

@RestController
@RequestMapping("/board")
public class ArticleController {
    
    @Autowired
    private ArticleService2 service;

    @Autowired
    private Article2Repository repository;

    // 전체조회
    @GetMapping("listall3")
    public List<Article2> listAll(){
        System.out.println("int4 / int8 / bigserial을 잘 불러오는 지 테스트");
        System.out.println();
        System.out.println();
        return service.getByListAll();
        // return service.getByListAllDesc(0,20);
    }
    // 페이지네이션 조회
    @GetMapping("PaginatedBoard")
    public List<Article2> pagenationBoard(
        @RequestParam(name = "page", defaultValue = "0") int page,
        @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC)Pageable pageable)
    {

        System.out.println("특정페이지만 출력");
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable);
        System.out.println();
        System.out.println();
        return service.getByListPerPage(pageable);
    }


    // 페이지네이션

    // 좋아요

    // 조회수 증가


}
