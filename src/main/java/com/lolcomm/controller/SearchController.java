package com.lolcomm.controller;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.lolcomm.api.RiotAPI;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.service.RiotMemberService;
@RequestMapping("/summoner/*")
@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	@Inject
	private RiotMemberService rmservice;
	@RequestMapping(value = "/{UserName}")
	public String summoner(@PathVariable("UserName") String UserName) throws Exception {
		logger.info("@@@ /summoner get 주소 호출");
		logger.info("@@@ 컨트롤러 sumonner() 호출");
		logger.info("./summoner/search.jsp 페이지 호출");
		Gson gson =new Gson();
		RiotAPI rioApi =new RiotAPI();
		
		String jsonString=rioApi.riotAPI("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+UserName);
		RiotMemberVO riotMemberVO=gson.fromJson(jsonString, RiotMemberVO.class);
		
		rmservice.insertMember(riotMemberVO);

		
		  String jsonString2=rioApi.riotAPI(
		  "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
		  +riotMemberVO.getId()); List<RiotMemberMasteryVO> masteryList=
		  gson.fromJson(jsonString2,new
		  TypeToken<List<RiotMemberMasteryVO>>(){}.getType());
		  
		 // rmservice.insertMastery(masteryList);  //시간을 줄여야할 필요가 있음
		 
		
		return "search";
	
	}
}
