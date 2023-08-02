package com.just_board.just_board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.just_board.just_board.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // List<Article> findListAllDesc();    
}
