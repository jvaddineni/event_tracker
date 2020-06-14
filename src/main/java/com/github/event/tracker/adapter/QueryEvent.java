package com.github.event.tracker.adapter;

import java.util.List;

import com.github.event.tracker.resource.request.EventRequest;
import com.github.event.tracker.resource.response.EventResponse;

public interface QueryEvent {
	List<EventResponse> query(EventRequest eventRequest);
}
