package com.example.mongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.domain.Event;
import com.example.mongodb.repository.EventRepository;

@RestController
@RequestMapping(value = "/events")
public class EventController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EventRepository repository;

	@GetMapping(path = "/{uid}")
	public ResponseEntity<List<Event>> getAllByParameters(@PathVariable String uid) {

		LOGGER.info(uid);

		return new ResponseEntity<List<Event>>(repository.findEventsByUid(uid), HttpStatus.OK);
	}

	@GetMapping(path = "/{eventUid}/contacts/{contactUid}")
	public ResponseEntity<List<Event>> getAllByParameters(@PathVariable String eventUid,
			@PathVariable String contactUid) {

		LOGGER.info(eventUid + " - " + contactUid);

		return new ResponseEntity<List<Event>>(repository.findEventsByUidAndContactUid(eventUid, contactUid),
				HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Event> save(@RequestBody Event event) {

		LOGGER.info(event.toString());

		return new ResponseEntity<Event>(repository.save(event), HttpStatus.OK);
	}

}
