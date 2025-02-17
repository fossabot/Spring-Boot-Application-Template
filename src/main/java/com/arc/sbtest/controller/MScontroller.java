package com.arc.sbtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arc.sbtest.repository.PersonRepository;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2
public class MScontroller 
{
	@Autowired
	PersonRepository personRepository;

	@GetMapping("/generic-hello")
	public ResponseEntity<String> noReqestParameter() 
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.set("CustomResponseHeader1", "CustomResponseHeaderValue1");
		responseHeaders.set("Custom-ResponseHeader-2", "Custom-Response-Header-Value-2");
		
		return new ResponseEntity<>("Welcome to generic greetings", responseHeaders, HttpStatus.OK);
	}
	
	@GetMapping("/personalized-hello")
	public String singleReqestParameter(@RequestParam(name="name", required=false, defaultValue="World") String name) 
	{
	    return "hello "+name;
	}
	
	@GetMapping("/loggers")
	public ResponseEntity<String> logMethod()
	{
		log.debug("Debugging log");
        log.info("Info log");
        log.warn("Hey, This is a warning!");
        log.error("Oops! We have an Error. OK");
        log.fatal("Damn! Fatal error. Please fix me.");
        
		return new ResponseEntity<>("logging", HttpStatus.OK);
	}
}
