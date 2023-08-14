package com.just_board.just_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.just_board.just_board.dto.CommentSummary;
import com.just_board.just_board.dto.CreateComment;
import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.entity.Comment;
import com.just_board.just_board.service.CommentService;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService service;

    @GetMapping("getComment")  //  -> 삭제
    public List<Comment> getComment(
            @RequestParam("articleId") Long articleId) {
        return service.getCommentList(articleId);
    }

    @GetMapping("getArticleComment") // -> 삭제
    public List<Comment> getArticleComment(
            @RequestParam("articleId") Long articleId) {
        return service.getArticleComment(articleId);
    }

    @GetMapping("getArticleDivisionComment")
    public List<CommentSummary> getArticleDivisionComment(
            @RequestParam("articleId") Long articleId) {
        return service.getArticleDivisionComment(articleId);
    }

    @PostMapping("postComment") //  -> 삭제
    public List<Comment> postComment(
            @RequestBody Article2 articleId) {
        return service.getCommentList(articleId);
    }

    @PostMapping("regComment")
    public String regComment(
        @RequestBody CommentSummary comment
    ){
        return service.createComment(comment);
        // return "댓글 등록 성공";
    }

    @PostMapping("regComment2") // 실패
    public String regComment2(
            @RequestBody CreateComment comment) {
        service.createComment2(comment);
        // service.save(comment);
        return "댓글 등록 성공";
    }

        @PostMapping("regComment3")
    public String regComment3(
            @RequestBody Comment comment) {
        service.createComment3(comment);
        // service.save(comment);
        return "댓글 등록 성공";
    }
}
