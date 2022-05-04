package com.invo.matchela.api.entity.cards;

import com.invo.matchela.core.AuditActiveAbstract;
import com.invo.matchela.core.constants.StringConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card_category")
public class CardCategory extends AuditActiveAbstract {

    @Id
    @SequenceGenerator(name = "card_category_seq", sequenceName = "card_category_seq", allocationSize = 1)
    @GeneratedValue(generator = "card_category_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = StringConstants.DEFAULT_NAME_SIZE)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = StringConstants.DEFAULT_MAX_LIMIT)
    private String detail;

    @NotNull
    @NotBlank
    @Size(min = StringConstants.DEFAULT_NAME_SIZE)
    private String defHashTag;

}
