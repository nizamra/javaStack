package com.sys.axsos.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sys.axsos.models.User;

public interface RepresintingUser extends CrudRepository<User, Long> {
	List<User> findAll();
}
