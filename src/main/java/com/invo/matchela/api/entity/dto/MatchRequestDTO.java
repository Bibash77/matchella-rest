package com.invo.matchela.api.entity.dto;

import com.invo.matchela.api.dto.CardDTO;
import com.invo.matchela.api.dto.UserDto;
import com.invo.matchela.api.entity.cards.Card;
import com.invo.matchela.core.authorization.user.User;
import com.invo.matchela.core.enums.MatchStatus;
import lombok.Data;

@Data
public class MatchRequestDTO extends AbstractDTO<Long> {
    private Long id;
    private CardDTO card;
    private UserDto user;
    private String requestMessage;
    private MatchStatus matchStatus;
}