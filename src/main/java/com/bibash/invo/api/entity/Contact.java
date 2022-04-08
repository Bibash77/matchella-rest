package com.bibash.invo.api.entity;

import com.bibash.invo.core.component.TextEncryptorConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(updatable = false)
	@Convert(converter = TextEncryptorConverter.class)
	private String email;
	
	@Convert(converter = TextEncryptorConverter.class)
	@Column(columnDefinition="text", updatable = false)
	private String message;
	
	private Date date;
	
	private boolean hidden;
}
