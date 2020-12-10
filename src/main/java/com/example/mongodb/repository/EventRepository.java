package com.example.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mongodb.domain.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

	@Query("{ 'uid' : ?0 }")
	List<Event> findEventsByUid(String uid);

	@Query("{ 'uid' : ?0, 'contact.uid' : ?1 }")
	List<Event> findEventsByUidAndContactUid(String eventUid, String contactUid);

}
