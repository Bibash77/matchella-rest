package com.invo.matchela.api.entity.cards;


import com.invo.matchela.core.AuditActiveAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class CardDetail extends AuditActiveAbstract {


    @Column(name = "likes")
    private Integer likes = 0;

    @Column(name = "un_likes")
    private Integer unlikes = 0;

    @Column(name = "views")
    private Integer views = 0;

    @Column(name = "rating")
    private Integer rating = 0;
}
