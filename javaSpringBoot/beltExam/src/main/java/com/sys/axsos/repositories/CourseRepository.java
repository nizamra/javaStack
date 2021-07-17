package com.sys.axsos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sys.axsos.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();

//	ArrayList<Course> findAllByGuestsBySize();
	ArrayList<Course> findAllByOrderByGuestsDesc();

}