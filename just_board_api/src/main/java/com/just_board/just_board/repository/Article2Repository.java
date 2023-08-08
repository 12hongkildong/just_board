package com.just_board.just_board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.just_board.just_board.entity.Article2;

@Repository
public interface Article2Repository extends JpaRepository<Article2,Long>{
    
    Page<Article2> findAll(Pageable pageable);
    int countBy();
    Double countBySubjectContainingOrContentContaining(String keyword1, String keyword2); // 키워드에 따른 페이지 수 출력

     List<Article2> findBySubjectContainingOrContentContaining(String keywordForSubject, String keywordForContent);
     List<Article2> findBySubjectContainingOrContentContaining(String keyword1, String keyword2, Pageable pageable);

}
