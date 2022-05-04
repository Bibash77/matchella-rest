package com.invo.matchela.api.dto;

public class UserFavCategoryDTO extends AbstractDTO<Long> {
    private Long id;
    private Long cardCategoryId;
    private Long userId;

    public UserFavCategoryDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setCardCategoryId(Long cardCategoryId) {
        this.cardCategoryId = cardCategoryId;
    }

    public Long getCardCategoryId() {
        return this.cardCategoryId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return this.userId;
    }
}