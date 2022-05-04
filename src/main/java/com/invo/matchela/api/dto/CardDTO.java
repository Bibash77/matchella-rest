package com.invo.matchela.api.dto;

public class CardDTO extends AbstractDTO<Long> {
    private Long id;

    public CardDTO() {
        // TODO document why this constructor is empty
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}