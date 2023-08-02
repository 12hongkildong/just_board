package com.just_board.just_board.service;

import java.util.List;

import com.just_board.just_board.entity.Article;

public interface ArticleService {

    List<Article> getByListAll();
    List<Article> getByListAllDesc(int offset, int size);
    
}
