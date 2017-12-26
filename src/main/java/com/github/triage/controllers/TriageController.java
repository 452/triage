package com.github.triage.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.triage.domain.Human;
import com.github.triage.domain.rest.Response;
import com.github.triage.processors.Stroke;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "triage")
@RestController
@RequestMapping("/api/v1")
public class TriageController {
	
	@ApiOperation(value = "Provides health of human", tags = "health")
	@RequestMapping(path = "/health", method = RequestMethod.GET)
	public ResponseEntity<Response> serviceHealthStatus() {
		Response response = new Response(makeNewHuman());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setAccessControlAllowOrigin("*");
		return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
	}
	
	private Human makeNewHuman() {
		Human human = new Human();
		human.setFullName("Harry Potter");
		human.setHealth(1000);
		human.addTraumas(new Stroke());
		return human;
	}

}