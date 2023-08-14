package com.just_board.just_board.dto;

import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class UpdateRefOrder {

    private int id;
    private Long articleId;
    private Long ref;
    private Long refOrder;

}
