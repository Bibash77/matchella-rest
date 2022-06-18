package com.invo.matchela.core.enums;

public enum MatchStatus {
    PENDING("Pending") , ACCEPTED("Accepted"), REJECTED("Rejected");
    private final String value;
    MatchStatus(String value) {
        this.value = value;
    }
}
