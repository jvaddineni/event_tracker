package com.github.event.tracker.resource.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class EventResponse {
		String eventType;
		String actorName;
		String avatarUrl;
		String createdAt;
		String repoName;
		String repoUrl;
}
