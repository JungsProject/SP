package com.lolcomm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.lolcomm.api.RiotAPI;
import com.lolcomm.domain.RiotMemberVO;
@RequestMapping("/summoner/*")
@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping(value = "/{UserName}")
	public String summoner(@PathVariable("UserName") String UserName) throws Exception {
		logger.info("@@@ /summoner get 주소 호출");
		logger.info("@@@ 컨트롤러 sumonner() 호출");
		logger.info("./summoner/search.jsp 페이지 호출");
		Gson gson =new Gson();
		RiotAPI rioApi =new RiotAPI();
		logger.info("userName="+UserName);
		String jsonString=rioApi.riotAPI("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+UserName);
		RiotMemberVO riotMemberVO=gson.fromJson(jsonString, RiotMemberVO.class);
		logger.info(riotMemberVO.toString());
		//select 한다음-> 있으면 update
		//없으면 ->insert
		
		return "search";
	}
}
