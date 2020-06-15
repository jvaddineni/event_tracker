package com.github.event.tracker.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.github.event.tracker.exception.BadRequestException;
import com.github.event.tracker.resource.request.EventRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventValidator {
	
	private static final String REPO_NAME_MUST_NOT_BE_EMPTY = "Repo Name must not be empty";
	private static final String EVENT_TYPE_MUST_NOT_BE_EMPTY = "Event type must not be empty";
	private static final String REPO_OWNER_NAME_MUST_NOT_BE_EMPTY = "Repo Owner name must not be empty";

	public boolean isValidRequest(EventRequest eventRequest){
		log.info("eventRequest "+eventRequest);
		if(eventRequest.getEventType() == null || eventRequest.getEventType().isEmpty()){
			throw new BadRequestException(HttpStatus.NOT_FOUND.value(), EVENT_TYPE_MUST_NOT_BE_EMPTY);
		}
		
		if(eventRequest.getOwner() == null || eventRequest.getOwner().isEmpty()){
			throw new BadRequestException(HttpStatus.NOT_FOUND.value(), REPO_OWNER_NAME_MUST_NOT_BE_EMPTY);
		}
		if(eventRequest.getRepoName() == null || eventRequest.getRepoName().isEmpty()){
			throw new BadRequestException(HttpStatus.NOT_FOUND.value(), REPO_NAME_MUST_NOT_BE_EMPTY);
		}
		return true;
	}
	
}
