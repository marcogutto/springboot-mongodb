package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodb.domain.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

}
