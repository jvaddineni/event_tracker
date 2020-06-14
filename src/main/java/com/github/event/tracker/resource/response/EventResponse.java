package com.github.event.tracker.resource.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
		String eventType;
		String actorName;
		String avatarUrl;
		String createdAt;
		String repoName;
		String repoUrl;
}
