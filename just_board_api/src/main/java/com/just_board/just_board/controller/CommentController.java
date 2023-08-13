package com.just_board.just_board.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.entity.Comment;
import com.just_board.just_board.service.CommentService;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService service;

    @GetMapping("getComment")
    public List<Comment> getComment(
            @RequestParam("articleId") Long articleId) {
        return service.getCommentList(articleId);
    }

    @GetMapping("getArticleComment")
    public List<Comment> getArticleComment(
            @RequestParam("articleId") Long articleId) {
        return service.getArticleComment(articleId);
    }

    @PostMapping("postComment")
    public List<Comment> postComment(
            @RequestBody Article2 articleId) {
        return service.getCommentList(articleId);
    }

}
