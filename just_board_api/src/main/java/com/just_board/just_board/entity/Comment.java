package com.just_board.just_board.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member memberId;    
        // @JoinColumn(name="member_id_id")
    // private Long memberId;    
    @ManyToOne
    @JoinColumn(name="article_id")
    private Article2 articleId;
    // private Long articleId;
    private Date date;
    @Column(name="ref_id")
    private Long refId;
    private Long step;
    private Long ref;
    @Column(name="ref_order")
    private Long refOrder;
    @Column(name="answer_num")
    private Long answerNum;    
}
