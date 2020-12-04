package com.example.mongodb.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

@Document
public class Message {
	
	private String dtm;
	private String uid;
	private String cuid;
	private String dir;
	private String type;
	private Body body;

}
