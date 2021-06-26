package com.sys.axsos.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sys.axsos.models.Question;

public interface RepresintingQuestion extends CrudRepository<Question, Long> {
	List<Question> findAll();


}
