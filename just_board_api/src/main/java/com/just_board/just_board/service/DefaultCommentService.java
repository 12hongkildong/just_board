package com.just_board.just_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.just_board.just_board.dto.CommentSummary;
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
        // return repository.findByArticleId_Id(articleId);
        Sort sort = Sort.by(Sort.Direction.ASC, "ref", "refOrder");
        List<Comment> comments = repository.findByArticleId_Id(articleId, sort);
        return comments;
    }

    @Override
    public List<CommentSummary> getArticleDivisionComment(Long articleId) {
        // TODO Auto-generated method stub
        // return repository.findByArticleId_Id(articleId);
        Sort sort = Sort.by(Sort.Direction.ASC, "ref", "refOrder");
        List<CommentSummary> comments = repository.findCommentSummaryByArticleId(articleId);
        return comments;
    }

    @Override
    public List<Comment> getCommentList(Article2 articleId) {
        // TODO Auto-generated method stub
        return repository.findAll();
    }


}
