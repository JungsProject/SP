package com.lolcomm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("*/matches/*")
public class SummonerController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@RequestMapping(value = "/{UserName}")
	public String matches() throws Exception {
		
		
		
		
		return "/search/matches";
	}
	
}
