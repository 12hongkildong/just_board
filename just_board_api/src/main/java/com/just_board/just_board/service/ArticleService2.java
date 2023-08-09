package com.just_board.just_board.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.just_board.just_board.entity.Article2;

public interface ArticleService2 {
    List<Article2> getByListAll();   // 게시글 총 리스트 -> 아마 안 쓸 거임
    List<Article2> getByListPerPage(Pageable pageable); // 게시글을 5개 단위로 잘라 주는 거
    int getTotalPages();    // 게시글 총 페이지 조회
    int getTotalPages(String keyword);    // 키워드에 따른 게시글 총 페이지 조회
    // List<Article2> getListBySearchKeyword(String keyword); // 제목+내용에 포함되는 키워드 가지고 오기
    List<Article2> getByListWithPageAndSearch(Pageable pageable, String keyword); // 키워드 검색과 게시글을 5개 단위로 잘라 주는 거

    void createArticle(Article2 article);
    void updateArticle(Article2 article);
}
