package com.example.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

@Document
@CompoundIndexes({ @CompoundIndex(name = "uid_message", def = "{'uid': 1, 'contact.uid' : 1, 'message.type': 1, 'message.body.text': 1}") })
public class Event {

	@Id
	private String id;
	
	private String event;
	private String token;
	private String uid;
	private String chatName;
	private Contact contact;
	private Message message;
	private String ack;
	
}
