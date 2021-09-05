package com.example.demo.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepository extends CrudRepository<Course,String> {

	
	//you have to just define the method here in the format findByProperty and Spring Data JPA will find the data
	//for you
	//e.g public List<Course> findByName(String name);
	public List<Course> findByTopicId(String topicId);
	
}
