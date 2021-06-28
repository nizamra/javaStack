package com.sys.axsos.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.City;

@Repository
public interface RepoForCity extends CrudRepository<City, Long> {

}
