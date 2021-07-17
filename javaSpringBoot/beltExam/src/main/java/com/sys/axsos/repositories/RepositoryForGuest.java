package com.sys.axsos.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.Guest;

@Repository
public interface RepositoryForGuest extends CrudRepository<Guest, Long> {
	List<Guest> findAll();

	Optional<Guest> findByEmail(String email);

	Guest findByFirstName(String username);
}
