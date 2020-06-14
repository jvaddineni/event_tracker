package com.github.event.tracker.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class InvalidResponseException extends RuntimeException {
	
	private int erroCode;
	private String errorMessage;

}
