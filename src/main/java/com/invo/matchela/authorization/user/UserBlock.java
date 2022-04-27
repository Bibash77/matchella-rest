package com.invo.matchela.authorization.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class UserBlock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private User userFrom;

	@ManyToOne
	@JoinColumn
	private User userTo;

	private Date date;
}
