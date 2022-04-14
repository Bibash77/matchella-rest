package com.invo.matchela.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class ConversationCheckedDate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Conversation conversation;
	
	private Long userId;
	
	private Date lastCheckedDate;
	
}