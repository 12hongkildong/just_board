package com.just_board.just_board.service;

import java.util.List;
import java.util.Optional;

import com.just_board.just_board.dto.CommentSummary;
import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.entity.Comment;

public interface CommentService {

    List<Comment> getCommentList(Long articleId); // 모든 댓글 다 가지고 오기

    List<Comment> getCommentList(Article2 articleId); // 지워야 할 거

    List<Comment> getArticleComment(Long articleId); // jpa를 이용해 게시글 번호에 해당하는 comment테이블의 값 다 가지고오기

    List<CommentSummary> getArticleDivisionComment(Long articleId); // dto를 이용해 comment테이블 중 내가 원하는 정보만 가지고 오기
}
