package com.just_board.just_board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.repository.Article2Repository;

@Service
public class DefaultArticleService2 implements ArticleService2 {

    @Autowired
    private Article2Repository repository;

    @Override
    public List<Article2> getByListAll() {
       return repository.findAll();
    }

    @Override
    public List<Article2> getByListPerPage(Pageable pageable) {
        // TODO Auto-generated method stub
        return repository.findAll(pageable).getContent();
    }

    @Override
    public int getTotalPages() {
        int totalArticles = repository.countBy(); // 총 게시글 개수
        int pageCount = (int) Math.round(totalArticles / 5);

        return pageCount;
    }
    
}
