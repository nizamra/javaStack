package com.sys.axsos.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.User;

@Repository
public interface RepoForUser extends CrudRepository<User, Long> {
	List<User> findAll();

	Optional<User> findByEmail(String email);
//	User findByEmail(String email);
//    Optional <User> findById(Long id);
}
