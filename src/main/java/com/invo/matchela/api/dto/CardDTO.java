package com.invo.matchela.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardDTO extends AbstractDTO<Long> {
    private Long id;
    private String title;
    private String cardType;
    private String detailBody;
//    @JsonFormat(pattern = "YYYY-MM-DD")
    private LocalDate cardExpiryDate;
    private Integer maxAllowedMatch;
    private CardCategoryDTO cardCategoryDTO;

}