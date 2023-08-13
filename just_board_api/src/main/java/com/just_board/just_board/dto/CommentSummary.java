package com.just_board.just_board.dto;

import java.util.Date;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

// @Table(name = "Comment")
public class CommentSummary {
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name="member_id")
    private String memberName;
    private Date date;
    private int refId;
    private int step;
    private int ref;
    private int refOrder;
    private Long answerNum;


    // @Column(name="member_id")
    // private int memberId;
    // private String memberName;
}
