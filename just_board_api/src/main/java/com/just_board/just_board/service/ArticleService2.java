package com.just_board.just_board.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.just_board.just_board.entity.Article2;

public interface ArticleService2 {
    List<Article2> getByListAll();
    List<Article2> getByListPerPage(Pageable pageable);
}
