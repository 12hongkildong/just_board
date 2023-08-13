package com.just_board.just_board.service;

import java.util.List;
import java.util.Optional;

import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.entity.Comment;

public interface CommentService {

    List<Comment> getCommentList(Long articleId);

    List<Comment> getCommentList(Article2 articleId);

    List<Comment> getArticleComment(Long articleId);
}
