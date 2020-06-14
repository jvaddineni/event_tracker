# event_tracker
This application will allow user to specify an owner , a repo , and an event type and then display matching events from GitHub API

## Clone

To clone this project using below url

```sh
git clone https://github.com/jvaddineni/event_tracker.git
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.github.event.tracker.EventTrackerApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```


# Swagger URL
http://localhost:8080/swagger-ui.html


Request:
-------

```json
{
	"eventType"="PushEvent",
	"owner"="jvaddineni",
	"repoName"="event_tracker"
}
```

Response: 
--------
```json
[
  {
    "eventType": "PushEvent",
    "actorName": "jvaddineni",
    "avatarUrl": "https://api.github.com/users/jvaddineni",
    "createdAt": "2020-06-13T15:17:58Z",
    "repoName": "jvaddineni/event_tracker",
    "repoUrl": "https://api.github.com/repos/jvaddineni/event_tracker"
  }
]
```
