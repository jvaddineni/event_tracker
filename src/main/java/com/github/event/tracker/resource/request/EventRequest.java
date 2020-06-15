package com.github.event.tracker.resource.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class EventRequest {
	String owner;
	String repoName;
	String eventType;
}
