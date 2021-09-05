package com.example.demo.topic;

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
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topic> getAllTopics(){
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	

	public Topic getTopic(String id) {
		return topicRepository.findById(id).get();
	}



	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}



	public void UpdateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		
	}



	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}

