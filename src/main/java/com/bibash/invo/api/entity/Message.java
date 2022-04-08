package com.bibash.invo.api.entity;

import com.bibash.invo.api.user.User;
import com.bibash.invo.core.component.TextEncryptorConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Message {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonIgnore
	@ManyToOne
	private Conversation conversation;

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private User userFrom;

	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private User userTo;

	@Convert(converter = TextEncryptorConverter.class)
	@Column(columnDefinition = "mediumtext", updatable = false)
	private String content;

	private Date date;

	private boolean allowedFormatting = false;

}