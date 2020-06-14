package com.github.event.tracker.github.api.feign_client.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Repo {

    private Integer id;
    private String name;
    private String url;

}
