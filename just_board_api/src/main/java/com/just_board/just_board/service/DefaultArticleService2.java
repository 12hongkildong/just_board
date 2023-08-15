package com.just_board.just_board.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.just_board.just_board.entity.Article2;
import com.just_board.just_board.repository.Article2Repository;

@Service
public class DefaultArticleService2 implements ArticleService2 {

    @Autowired
    private Article2Repository repository;

    @Override
    public List<Article2> getByListAll() {
       return repository.findAll();
    }


    // 게시글을 다섯 개로 잘라 가지고 오기? 
    @Override
    public List<Article2> getByListPerPage(Pageable pageable) {
        // TODO Auto-generated method stub
        return repository.findAll(pageable).getContent();
    }


    // 전체 게시글 페이지 수
    @Override
    public int getTotalPages() {
        int totalArticles = repository.countBy(); // 총 게시글 개수
        
        int pageCount = (int) Math.ceil(totalArticles / 5);
        System.out.println(pageCount);

        return pageCount;
    }


    // 검색을 이용한 조회
    // @Override
    // public List<Article2> getListBySearchKeyword(String keyword) {
    //     return repository.findBySubjectContainingOrContentContaining(keyword, keyword);
    // }

    // 검색한 키워드에 맞게 리스트 조회
    @Override
    public List<Article2> getByListWithPageAndSearch(Pageable pageable, String keyword) {
        // TODO Auto-generated method stub
        return repository.findBySubjectContainingOrContentContaining(keyword, keyword, pageable);
    }
    
    // 전체 게시글 페이지 수
    @Override
    public int getTotalPages(String keyword) {
        Double totalArticles = repository.countBySubjectContainingOrContentContaining(keyword, keyword); // 총 게시글 개수
        int pageCount = (int) Math.ceil(totalArticles / 5);
        System.out.println(pageCount);

        return pageCount;
    }

    // 글 작성
    @Override
    public void createArticle(Article2 article) {
        Article2 setArticle = new Article2();
        Date currentDate = new Date();

        setArticle.setMemberId(article.getMemberId());
        setArticle.setSubject(article.getSubject());
        setArticle.setContent(article.getContent());
        setArticle.setDate(currentDate);

        repository.save(setArticle);
        
    }

    // 글 수정
    @Override
    public void updateArticle(Article2 article) {
        Article2 updateArticle = new Article2();

        updateArticle.setId(article.getId());
        updateArticle.setSubject(article.getSubject());
        updateArticle.setContent(article.getContent());
        updateArticle.setMemberId(article.getMemberId());
        updateArticle.setDate(article.getDate());
        updateArticle.setHit(article.getHit());
        updateArticle.setLikeCount(article.getLikeCount());


        repository.save(updateArticle);
    }

    // 글 삭제
    @Override
    public void deleteArticle(Long id) {
        // TODO Auto-generated method stub
        repository.deleteById(id);
    }



}
