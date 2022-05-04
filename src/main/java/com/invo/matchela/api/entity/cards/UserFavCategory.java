package com.invo.matchela.api.entity.cards;

import com.invo.matchela.core.AuditActiveAbstract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_fav_category")
public class UserFavCategory extends AuditActiveAbstract {
    @Id
    @SequenceGenerator(name = "user_fav_category_seq", sequenceName = "user_fav_category_seq", allocationSize = 1)
    @GeneratedValue(generator = "user_fav_category_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "card_category_id", columnDefinition = "bigint references card_category(id)")
    private Long cardCategoryId;

    @Column(name = "user_id", columnDefinition = "bigint references user(id)")
    private Long userId;

}
