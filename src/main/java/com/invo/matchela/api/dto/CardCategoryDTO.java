package com.invo.matchela.api.dto;

public class CardCategoryDTO extends AbstractDTO<Long> {
    private Long id;
    private String name;
    private String detail;
    private String defHashTag;

    public CardCategoryDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDefHashTag(String defHashTag) {
        this.defHashTag = defHashTag;
    }

    public String getDefHashTag() {
        return this.defHashTag;
    }
}