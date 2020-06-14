# event_tracker
This application will allow user to specify an owner , a repo , and an event type and then display matching events from GitHub API

# Swagger URL
http://localhost:8080/swagger-ui.html

http://localhost:8080/event?eventType=PushEvent2&owner=jvaddineni&repoName=event_tracker

Request:

{
	"eventType"="PushEvent",
	"owner"="jvaddineni",
	"repoName"="event_tracker"
}

Response: 

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