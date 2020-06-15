package com.github.event.tracker.adapter;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.event.tracker.exception.BadRequestException;
import com.github.event.tracker.github.api.feign_client.response.Actor;
import com.github.event.tracker.github.api.feign_client.response.Event;
import com.github.event.tracker.github.api.feign_client.response.Repo;
import com.github.event.tracker.resource.request.EventRequest;
import com.github.event.tracker.resource.response.EventResponse;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class GithubQueryEventAdapterTest {

	@Autowired 
    private GithubQueryEventAdapter githubQueryEventAdapter;
    
    @BeforeEach
    void setUp() {
    }

    @Test
    void queryWithOkResponse() {   
        EventRequest eventRequest = EventRequest.builder().eventType("PushEvent")
        		.repoName("event_tracker")
        		.owner("jvaddineni").build();
        Repo repo1 = Repo.builder()
        			.name("jvaddineni/event_tracker")
        			.url("https://api.github.com/repos/jvaddineni/event_tracker")
        			.build();

        Actor actor1 = Actor.builder()
        			.avatarUrl("https://avatars.githubusercontent.com/u/41030359?")
        			.login("jvaddineni")
        			.build();
        
        Event obj = Event.builder()
        			.created_at("2020-06-14T10:20:15Z")
        			.id("12624006900")
        			.isPublic(true)
        			.repo(repo1)
        			.type("PushEvent")
        			.actor(actor1).build();

        Event obj2 = Event.builder()
    			.created_at("2020-06-14T03:04:40Z")
    			.id("12624006900")
    			.isPublic(true)
    			.type("PushEvent")
    			.repo(repo1)
    			.actor(actor1).build();
    
        List<Event> eventList = Arrays.asList(obj,obj2);
        List<EventResponse> actualEventList = githubQueryEventAdapter.query(eventRequest);
        Assertions.assertEquals(8, actualEventList.size());
    }
    
    @Test
    void queryWithErrorResponse() {   
        EventRequest eventRequest = EventRequest.builder().eventType("PushEvent")
        		.repoName("event_tracker")
        		//.owner("jvaddineni")
        		.build();
        Repo repo1 = Repo.builder()
        			.name("jvaddineni/event_tracker")
        			.url("https://api.github.com/repos/jvaddineni/event_tracker")
        			.build();

        Actor actor1 = Actor.builder()
        			.avatarUrl("https://avatars.githubusercontent.com/u/41030359?")
        			.login("jvaddineni")
        			.build();
        
        Event obj = Event.builder()
        			.created_at("2020-06-14T10:20:15Z")
        			.id("12624006900")
        			.isPublic(true)
        			.repo(repo1)
        			.type("PushEvent")
        			.actor(actor1).build();

        Event obj2 = Event.builder()
    			.created_at("2020-06-14T03:04:40Z")
    			.id("12624006900")
    			.isPublic(true)
    			.type("PushEvent")
    			.repo(repo1)
    			.actor(actor1).build();
    
        List<Event> eventList = Arrays.asList(obj,obj2);
        
        Exception exception = assertThrows(
        		Exception.class,
    			() -> githubQueryEventAdapter.query(eventRequest));

        Assertions.assertEquals(null, exception.getMessage());
    }
}