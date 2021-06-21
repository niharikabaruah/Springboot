package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//Business Service --other services/controllers are dependent on it
//In Spring, business service is typically singleton, when the app starts up Spring creates an instance of the service
//and keeps it in its memory

@Service
public class TopicService {
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
				new Topic("HTML","HTML 5","HTML 5 Description"),
				new Topic("Spring","Spring FrameWork","Spring Description"),
				new Topic("Java","Core Java","Core Java Description"),
				new Topic("Java","Java 8","Java 8 Description"))
				
				
				);
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	

	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}



	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}



	public void UpdateTopic(String id, Topic topic) {
		for(int i=0;i<topics.size();i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
		
	}



	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}
}

