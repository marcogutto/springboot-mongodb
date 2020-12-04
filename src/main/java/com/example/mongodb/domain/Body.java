package com.example.mongodb.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

@Document
public class Body {
	
	private String text;
	private String thumb;
	private String mimetype;
	private String url;
	private String media;

}
