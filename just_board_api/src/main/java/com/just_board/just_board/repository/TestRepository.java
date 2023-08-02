package com.just_board.just_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.just_board.just_board.entity.testtable;

@Repository
public interface TestRepository  extends JpaRepository<testtable, Integer>  {
    
}
