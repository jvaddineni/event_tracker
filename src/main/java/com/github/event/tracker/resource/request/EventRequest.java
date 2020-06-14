package com.github.event.tracker.resource.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventRequest {
	String owner;
	String repoName;
	String eventType;
}
