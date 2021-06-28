package com.sys.axsos.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.Event;

@Repository
public interface RepoForEvent extends CrudRepository<Event, Long> {
	List<Event> findAll();

	List<Event> findByStateContaining(String state);

	List<Event> findByStateNotContaining(String state);

	Optional<Event> findByName(String name);

}
