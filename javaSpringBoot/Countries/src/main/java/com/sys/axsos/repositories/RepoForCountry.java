package com.sys.axsos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.Country;

@Repository
public interface RepoForCountry extends CrudRepository<Country, Long> {
	List<Country> findAll();
}
