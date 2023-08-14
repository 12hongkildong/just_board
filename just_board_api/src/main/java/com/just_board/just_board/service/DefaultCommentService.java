package com.just_board.just_board.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.just_board.just_board.dto.CommentSummary;
import com.just_board.just_board.dto.CreateComment;
import com.just_board.just_board.dto.UpdateRefOrder;
import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.entity.Comment;
import com.just_board.just_board.repository.CommentRepository;

@Service
public class DefaultCommentService implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override // 삭제할 메소드
    public List<Comment> getCommentList(Long articleId) {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override // 삭제할 메소드
    public List<Comment> getArticleComment(Long articleId) {
        // TODO Auto-generated method stub
        // return repository.findByArticleId_Id(articleId);
        Sort sort = Sort.by(Sort.Direction.ASC, "ref", "refOrder");
        List<Comment> comments = repository.findByArticleId_Id(articleId, sort);
        return comments;
    }

    @Override // 삭제할 메소드
    public List<CommentSummary> getArticleDivisionComment(Long articleId) {
        // TODO Auto-generated method stub
        // return repository.findByArticleId_Id(articleId);
        Sort sort = Sort.by(Sort.Direction.ASC, "ref", "refOrder");
        List<CommentSummary> comments = repository.findCommentSummaryByArticleId(articleId);
        return comments;
    }

    @Override // 삭제할 메소드
    public List<Comment> getCommentList(Article2 articleId) {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override  // 삭제할 메소드
    public String createComment(CommentSummary comment) {
        
        // repository.insertDto(comment);
        // repository.insertComment();
        return "댓글 쓰기 성공";
    }

    @Override  // 삭제할 메소드
    public String createComment2(CreateComment comment) {
        // TODO Auto-generated method stub
        System.out.println(comment);
        repository.insertComment(comment.getContent(),comment.getMemberId(),comment.getArticleId());
        return "댓글 쓰기 성공?";
    }

    @Override
    public String createComment3(Comment comment) {
        // TODO Auto-generated method stub
        // Date currentDate = new Date();
        // comment.setDate(currentDate); // 시간을 java로 계산한 건데 js에서 계산해서 보내주는 걸로 바꿈 
        repository.save(comment);

        return "댓글성공";
    }

    @Override   // 삭제할 메소드
    public String updateRefOrder(Comment updateTarget) {
        // TODO Auto-generated method stub
        // repository.updateRefOrder(updateTarget.getArticleId(), updateTarget.getRef(), updateTarget.getRefOrder());
        repository.updateRefOrder2(updateTarget.getArticleId(), updateTarget.getRef(), updateTarget.getRefOrder());
        return "refOrder 업데이트 성공";
    }

    @Override
    public String updateRefOrder(UpdateRefOrder updateTarget) {
        // TODO Auto-generated method stub
        repository.updateRefOrder(updateTarget.getArticleId(), updateTarget.getRef(), updateTarget.getRefOrder());
        // repository.updateRefOrderByArticleIdAndRefAndRefOrderGreaterThanEqual(updateTarget.getArticleId(), updateTarget.getRef(), updateTarget.getRefOrder());
        System.out.println(updateTarget.getArticleId()+" / "+ updateTarget.getRef()+ " / "+updateTarget.getRefOrder());
         System.out.println(updateTarget.getId()+" / "+ updateTarget.getRef()+ " / "+updateTarget.getRefOrder());
       return "refOrder 업데이트 성공";
    }

}
