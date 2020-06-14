package com.github.event.tracker.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.github.event.tracker.exception.InvalidResponseException;
import com.github.event.tracker.github.api.feign_client.GitHubEventFeignClient;
import com.github.event.tracker.github.api.feign_client.response.Event;
import com.github.event.tracker.resource.request.EventRequest;
import com.github.event.tracker.resource.response.EventResponse;
import com.github.event.tracker.validator.EventValidator;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GithubQueryEventAdapter implements QueryEvent {

	private GitHubEventFeignClient gitHubEventFeignClient;
	private EventValidator eventValidator;
	
	@Override
	public List<EventResponse> query(EventRequest eventRequest) {
		eventValidator.isValidRequest(eventRequest);
		ResponseEntity<List<Event>> eventListResponseEntity = gitHubEventFeignClient.queryEvent(eventRequest.getOwner(), eventRequest.getRepoName());
		if(eventListResponseEntity.getStatusCode() == HttpStatus.OK){
			List<Event> events = eventListResponseEntity.getBody();
			return events.stream()
			.filter(event -> eventRequest.getEventType().equals(event.getType()))
			.map(event -> new EventResponse(event.getType(), event.getActor().getLogin(), event.getActor().getUrl(), event.getCreated_at(), event.getRepo().getName(), event.getRepo().getUrl()))
			.collect(Collectors.toList());
		}
		throw new InvalidResponseException(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Invalid response");
	}
}

