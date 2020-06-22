package com.lolcomm.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.lolcomm.api.RiotAPI;
import com.lolcomm.domain.LeagueEntryVO;
import com.lolcomm.domain.RiotMemberLeague;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.service.RiotMemberService;
@RequestMapping("/summoner/*")
@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Inject
	private RiotMemberService rmservice;
	
	@RequestMapping(value = "/{UserName}", method=RequestMethod.GET)
	public String summoner(@PathVariable("UserName") String UserName,Model model) throws Exception {
		logger.info("@@@ /summoner get 주소 호출");
		logger.info("@@@ 컨트롤러 sumonner() 호출");
		logger.info("./summoner/search.jsp 페이지 호출");
		Gson gson =new Gson();
		RiotAPI riotApi =new RiotAPI();
		
		String jsonString=riotApi.riotAPI("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+UserName);
		RiotMemberVO riotMemberVO=gson.fromJson(jsonString, RiotMemberVO.class);
		//riotMemberVO에 gson데이터 담기
		
		Map<String,Object> Summoner = new HashMap<String,Object>();
		Summoner.put("id", riotMemberVO.getId());
		Summoner.put("accountId", riotMemberVO.getAccountId());
		Summoner.put("puuid", riotMemberVO.getPuuid());
		Summoner.put("name", riotMemberVO.getName());
		Summoner.put("profileIconId", riotMemberVO.getProfileIconId());
		Summoner.put("revisionDate", riotMemberVO.getRevisionDate());
		Summoner.put("summonerLevel", riotMemberVO.getSummonerLevel());
		
		
		rmservice.insertMember(riotMemberVO);

		  String jsonString2=riotApi.riotAPI(
		  "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/"
		  +riotMemberVO.getId()); 
		  List<RiotMemberMasteryVO> masteryList=
		  gson.fromJson(jsonString2,new
		  TypeToken<List<RiotMemberMasteryVO>>(){}.getType());
		  
		  rmservice.insertMastery(masteryList);  //시간을 줄여야할 필요가 있음
		 //테스트
		 String jsonString3=riotApi.riotAPI("https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+riotMemberVO.getId());
		 List<RiotMemberLeague> LeagueList= gson.fromJson(jsonString3, new TypeToken<List<RiotMemberLeague>>() {}.getType());
		  logger.info(LeagueList.toString());

		  rmservice.insertLeague(LeagueList);
		  
		 //소환사 랭크정보 
		 String jsonString4=riotApi.riotAPI("https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+riotMemberVO.getId()); 
		 
//		 LeagueEntryVO leagueEntryVO = gson.fromJson(jsonString4, LeagueEntryVO.class);

		 
		 List<LeagueEntryVO> league = gson.fromJson(jsonString4, new TypeToken<List<LeagueEntryVO>>() {}.getType());
		 
		model.addAttribute("UserName",UserName);
		
		model.addAttribute("Summoner",Summoner);
		
		String test1 = league.get(0).getTier();
		
		model.addAttribute("league",league);
		model.addAttribute("test1",test1);
		model.addAttribute("jsonString3",jsonString3);
		  
		return "search/search";
	
	}
}
