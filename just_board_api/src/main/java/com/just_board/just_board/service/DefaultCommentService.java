package com.just_board.just_board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.entity.Comment;
import com.just_board.just_board.repository.CommentRepository;

@Service
public class DefaultCommentService implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public List<Comment> getCommentList(Long articleId) {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public List<Comment> getArticleComment(Long articleId) {
        // TODO Auto-generated method stub
        return repository.findByArticleId_Id(articleId);
    }

    @Override
    public List<Comment> getCommentList(Article2 articleId) {
        // TODO Auto-generated method stub
        return repository.findAll();
    }






}
