package com.just_board.just_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.just_board.just_board.entity.Article;
import com.just_board.just_board.repository.ArticleRepository;

@Service
public class DefaultArticleService implements ArticleService{
    @Autowired
    private ArticleRepository repository;

    @Override
    public List<Article> getByListAll() {
        return repository.findAll();
    }

    @Override
    public List<Article> getByListAllDesc(int offset, int size) {
        System.out.println("여기는");
        return repository.findAll();
    }

}
