package com.just_board.just_board.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.just_board.just_board.dto.CommentSummary;
import com.just_board.just_board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{

    List<Comment> findByArticleId_Id(Long articleId);

    List<Comment> findByArticleId_Id(Long articleId, Sort sort);

    // @Query("SELECT new com.example.CommentSummary(c.id, c.content, c.memberId.name) FROM Comment c WHERE c.articleId.id = :articleId ORDER BY c.ref ASC, c.refOrder ASC")
    // @Query("SELECT new com.example.CommentSummary(c.id, c.content, c.member.name, c.date, c.refId, c.step, c.ref, c.refOrder, c.answerNum) FROM Comment c WHERE c.article.id = :articleId ORDER BY c.ref ASC, c.refOrder ASC")
    // @Query("SELECT c.id, c.content FROM Comment c WHERE c.articleId.id = :articleId ORDER BY c.ref ASC, c.refOrder ASC")
    
    
    // @Query("SELECT  new com.just_board.just_board.dto.CommentSummary(c.id, c.content, c.memberId.Id, c.date) FROM Comment c WHERE c.articleId.id = :articleId ORDER BY c.ref ASC, c.refOrder ASC")
    @Query("SELECT  new com.just_board.just_board.dto.CommentSummary(c.id, c.content, c.memberId.name, c.date, c.refId, c.step, c.ref, c.refOrder, c.answerNum) FROM Comment c WHERE c.articleId.id = :articleId ORDER BY c.ref ASC, c.refOrder ASC")
    List<CommentSummary> findCommentSummaryByArticleId(Long articleId);
    
    // @Query("SELECT  new com.just_board.just_board.dto.CommentSummary(c.id, c.content, c.memberId.name, c.date, c.refId, c.step, c.ref, c.refOrder, c.answerNum) FROM Comment c WHERE c.articleId.id = :articleId ORDER BY c.ref ASC, c.refOrder ASC")
    // void insertDto(CommentSummary comment);

    @Modifying
    @Query("INSERT INTO Comment (content, memberId, articleId) VALUES (:content, :memberId, :articleId)")
    void insertComment(@Param("content") String content, @Param("memberId") Long memberId, @Param("articleId") Long articleId);

    @Query("UPDATE Comment c SET c.refOrder = c.refOrder + 1 WHERE c.articleId = :articleId AND c.ref = :ref AND c.refOrder >= :refOrder")
    void updateRefOrder(@Param("articleId") Long articleId, @Param("ref") Long ref, @Param("refOrder") Long refOrder);
}   
