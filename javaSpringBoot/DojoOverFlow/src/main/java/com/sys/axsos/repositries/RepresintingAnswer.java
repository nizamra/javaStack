package com.sys.axsos.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sys.axsos.models.Answer;

public interface RepresintingAnswer extends CrudRepository<Answer, Long> {
	List<Answer> findAll();
}
