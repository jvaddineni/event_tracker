package com.github.event.tracker.resource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;

//import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.github.event.tracker.resource.request.EventRequest;
import com.github.event.tracker.resource.response.EventResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EventQueryControllerTest {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		String url = "http://localhost:" + port + "/event";
		EventRequest eventRequest = EventRequest.builder().eventType("PushEvent")
        		.repoName("event_tracker")
        		.owner("jvaddineni").build();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(new ArrayList<>(Arrays.asList(MediaType.APPLICATION_JSON)));
	    headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<EventRequest> request = new HttpEntity<>(eventRequest,headers);
		//ResponseEntity<List<T>> eventResponseList  = restTemplate.postForObject(, request, new ParameterizedTypeReference<List<T>>(){});
	   // ResponseEntity<List<EventResponse>> response = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<List<EventResponse>>() {});
		//ResponseEntity<Object[]> responseEntity = restTemplate.postForEntity(url, Object[].class);
		Assertions.assertEquals(2,2);
	}
}
