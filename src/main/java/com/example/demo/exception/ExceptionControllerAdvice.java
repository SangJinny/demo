package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<Map<String, Object>> handleCustomErrorException(CustomException ex) {
		Map<String, Object> responseBody = new HashMap<String, Object>();
		responseBody.put("message", ex.getMessage());
		return ResponseEntity.ok(responseBody);
	}
}
