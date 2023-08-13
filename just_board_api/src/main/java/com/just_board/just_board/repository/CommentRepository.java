package com.just_board.just_board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.just_board.just_board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{

    List<Comment> findByArticleId_Id(Long articleId);
    
}
