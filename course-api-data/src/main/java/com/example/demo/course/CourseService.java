package com.example.demo.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

//Business Service --other services/controllers are dependent on it
//In Spring, business service is typically singleton, when the app starts up Spring creates an instance of the service
//and keeps it in its memory
//@EnableJpaRepositories("com.example.demo.topic.TopicRepository")
@EnableAutoConfiguration
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	

	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}



	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}



	public void UpdateCourse(Course course) {
		courseRepository.save(course);
		
	}



	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}

