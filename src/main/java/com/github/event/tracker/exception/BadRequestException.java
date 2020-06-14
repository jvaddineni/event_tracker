package com.github.event.tracker.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BadRequestException extends RuntimeException{
	private int erroCode;
	private String errorMessage;
		
}
