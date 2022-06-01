package com.invo.matchela.api.entity.cards;

import com.invo.matchela.core.AuditActiveAbstract;
import com.invo.matchela.core.authorization.user.User;
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

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user;

    @Column(name = "on_fav_count")
    private Long onFavCount;

    @Column(name = "current_fav")
    private Boolean currentFav;

}
