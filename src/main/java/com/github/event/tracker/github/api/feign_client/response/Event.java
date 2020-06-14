package com.github.event.tracker.github.api.feign_client.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {

    private String id;
    private String type;
    private Actor actor;
    private Repo repo;
    private boolean isPublic;
    private String created_at;

}
