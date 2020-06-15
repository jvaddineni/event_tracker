package com.github.event.tracker.github.api.feign_client.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Actor {
    private Integer id;
    private String login;
    private String displayLogin;
    private String gravatarId;
    private String url;
    private String avatarUrl;

}
