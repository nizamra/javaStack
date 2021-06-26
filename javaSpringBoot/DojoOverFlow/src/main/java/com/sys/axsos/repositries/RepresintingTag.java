package com.sys.axsos.repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sys.axsos.models.Tag;

public interface RepresintingTag extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
	Tag findBySubjectIgnoreCase(String subject);

}
