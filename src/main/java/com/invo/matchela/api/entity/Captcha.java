package com.invo.matchela.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Captcha {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(columnDefinition="text")
	private String image;
	
	@JsonIgnore
	private String text;
	
	@JsonIgnore
	private Date date;
	
	@JsonIgnore
	@Column(unique=true, nullable=false)
	private String hashCode;
}
