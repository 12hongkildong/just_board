package com.just_board.just_board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.just_board.just_board.entity.Article2;

@Repository
public interface Article2Repository extends JpaRepository<Article2,Long>{
    
    Page<Article2> findAll(Pageable pageable);
}
