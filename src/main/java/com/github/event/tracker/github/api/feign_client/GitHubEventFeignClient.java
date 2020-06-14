package com.github.event.tracker.github.api.feign_client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.event.tracker.github.api.feign_client.response.Event;

import feign.Logger;

@FeignClient(name = "github.feign.client", url = "${github.event.url}",configuration=GitHubEventFeignClient.FeignClientConfig.class)
public interface GitHubEventFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/repos/{owner}/{repo}/events") 
	ResponseEntity<List<Event>> queryEvent(@PathVariable("owner") String owner,@PathVariable("repo") String repo);
	
	static class FeignClientConfig{
		  @Bean
		    public Logger.Level feignLogger() {
		        return Logger.Level.FULL;   
		    }
	}
}
