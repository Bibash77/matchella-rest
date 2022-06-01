package com.invo.matchela.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFavCategoryDTO extends AbstractDTO<Long> {
    private Long id;
    private Long cardCategoryId;
    private Long userId;
    private Boolean currentFav;
}