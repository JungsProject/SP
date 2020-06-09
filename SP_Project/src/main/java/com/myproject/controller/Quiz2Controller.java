package com.myproject.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.service.Quiz2Service;

@Controller
@RequestMapping("/quiz2/*")
public class Quiz2Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Quiz2Controller.class);
	
	@Inject
	private Quiz2Service service;
	
	

}
