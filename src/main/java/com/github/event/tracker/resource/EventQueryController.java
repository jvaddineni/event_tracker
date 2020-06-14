package com.github.event.tracker.resource;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.event.tracker.adapter.QueryEvent;
import com.github.event.tracker.resource.request.EventRequest;
import com.github.event.tracker.resource.response.EventResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@Api(value="Allow the user to specify an owner , a repo, and an event type Endpoint"
		+ "and then display matching events from GitHub events API  ")
public class EventQueryController {

	private QueryEvent queryEvent;

	@PostMapping("/event")
	@ApiOperation(
	        value = "query github repo events",
	        consumes="application/json",
	        produces="application/json"
	    )
	    @ApiResponses(
	        value = {
	            @ApiResponse(code = 200, message = "Show event type ,actor information and timestamp of eveents"),
	            @ApiResponse(code = 400, message = "Invalid request"),
	            @ApiResponse(code = 500, message = "Invalid response")
	        }
	    )	
	public List<EventResponse> queryGitHubRepoEvents(EventRequest eventRequest){
		return queryEvent.query(eventRequest);
	}
}
