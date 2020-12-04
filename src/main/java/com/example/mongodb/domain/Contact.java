package com.example.mongodb.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

@Document
public class Contact {
	
	private String uid;
	private String name;
	private String type;

}
