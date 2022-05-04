package com.invo.matchela.api.entity.cards;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
public class Card extends CardDetail {
    @Id
    @SequenceGenerator(name = "card_seq", sequenceName = "card_seq", allocationSize = 1)
    @GeneratedValue(generator = "card_seq", strategy = GenerationType.SEQUENCE)
    private Long id;


    @NotNull
    @NotBlank
    @Size(min = StringConstants.DEFAULT_NAME_SIZE)
    private String title;


    @Size(min = StringConstants.DEFAULT_NAME_SIZE)
    private String cardType;

    // todo add destination in different way
    private String destinationLocation;

    @NotNull
    @NotBlank
    @Lob
    private String detailBody;

    @OneToOne
    @JoinColumn(name = "card_category_id", referencedColumnName = "id")
    private CardCategory cardCategory;

    @NotNull
    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "card_expiry_date")
    private LocalDate cardExpiryDate;

    @NotNull
    @NotBlank
    @Column(name = "maxAllowedMatch")
    private Integer maxAllowedMatch;
}
