package com.sys.axsos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.MesComment;

@Repository
public interface RepoForMesComment extends CrudRepository<MesComment, Long> {
	List<MesComment> findAll();
}
