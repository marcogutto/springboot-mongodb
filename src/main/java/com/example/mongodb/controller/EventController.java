package com.example.mongodb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.domain.Event;
import com.example.mongodb.repository.EventRepository;

@RestController
@RequestMapping(value = "/event")
public class EventController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EventRepository repository;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Event> save(@RequestBody Event event){
		
		LOGGER.info(event.toString());
		
		return new ResponseEntity<Event>(repository.save(event), HttpStatus.OK);
	}
	
	
}
