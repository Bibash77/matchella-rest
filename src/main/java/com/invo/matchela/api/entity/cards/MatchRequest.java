package com.invo.matchela.api.entity.cards;

import com.invo.matchela.core.AuditActiveAbstract;
import com.invo.matchela.core.authorization.user.User;
import com.invo.matchela.core.enums.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "match_request")
public class MatchRequest extends AuditActiveAbstract {

    @Id
    @SequenceGenerator(name = "match_request_seq", sequenceName = "match_request_seq", allocationSize = 1)
    @GeneratedValue(generator = "match_request_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "request_message")
    private String requestMessage;

    @Column(name = "match_status")
    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;

}
