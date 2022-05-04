package com.invo.matchela.api.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import com.invo.matchela.core.enums.RoleType;
import com.invo.matchela.core.enums.Status;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_notification")
public class Notification {

    @Id
    @GeneratedValue
    private Long id;

    private Long fromRole;
    private Long toId;
    private RoleType toRole;
    private Long fromId;
    private String message;
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Transient
    private String itemName;

    @Transient
    private Double transactionAmount;

    private String actionType;

    private Boolean isSeen = false;

    @Transient
    private String orderCode;

    @Transient
    private String quantity;
}
