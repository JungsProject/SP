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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lolcomm.api.RiotAPI;
import com.lolcomm.domain.LeagueEntryVO;
import com.lolcomm.domain.MatchReferenceDTO;
import com.lolcomm.domain.RiotMemberLeague;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.domain.TeamStatsDTO;
import com.lolcomm.domain.matchListVO;
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
		
		
		//소환사정보 
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
		
		//소환사정보 
		model.addAttribute("Summoner",Summoner);
		
		
		//----------------------------------------------------------------------// 
		
		String accountId = (String) Summoner.get("accountId");
		
		rmservice.insertMember(riotMemberVO);

		//소환사 랭크전적
		 String jsonString3=riotApi.riotAPI("https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+riotMemberVO.getId());
		 List<RiotMemberLeague> LeagueList= gson.fromJson(jsonString3, new TypeToken<List<RiotMemberLeague>>() {}.getType());
		  logger.info(LeagueList.toString());
		  logger.info("@@@@@@@@@@@@@@@@@@");

		  rmservice.insertLeague(LeagueList);
		  
			//랭크전적
//			model.addAttribute("LeagueList",LeagueList);
			
			Map<String,Object> SoloRank = new HashMap<String,Object>();
			
			SoloRank.put("Tier", LeagueList.get(1).getTier());
			SoloRank.put("rank", LeagueList.get(1).getRank());
			SoloRank.put("leaguePoints", LeagueList.get(1).getLeaguePoints());
			SoloRank.put("wins", LeagueList.get(1).getWins());
			SoloRank.put("losses", LeagueList.get(1).getLosses());
			
			
			Map<String,Object> TeamRank = new HashMap<String,Object>();
			
			TeamRank.put("Tier", LeagueList.get(0).getTier());
			SoloRank.put("rank", LeagueList.get(0).getRank());
			TeamRank.put("leaguePoints", LeagueList.get(0).getLeaguePoints());
			TeamRank.put("wins", LeagueList.get(0).getWins());
			TeamRank.put("losses", LeagueList.get(0).getLosses());
			
			model.addAttribute("SoloRank",SoloRank);
			model.addAttribute("TeamRank",TeamRank);
		  
		  String summonerId = LeagueList.get(0).getSummonerId();
		  
		 //----------------------------------------------------------------------// 
		  
		 //소환사 경기정보 
		 String jsonString4=riotApi.riotAPI("https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"+accountId+"?endIndex="+3); 
		 
		 JsonParser jsonParse = new JsonParser();
		 
		 JsonObject jsonObj = (JsonObject) jsonParse.parse(riotApi.riotAPI("https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"+accountId+"?season="+13+"&queue="+420));
		 
		 logger.info(jsonObj.toString());
		 
		 
		 
		 List<MatchReferenceDTO> matchesList = gson.fromJson(jsonObj.get("matches"), new TypeToken<List<MatchReferenceDTO>>() {}.getType());
//		 JsonArray totalGames = (JsonArray) jsonObj.get("totalGames");
		 
		 JsonElement totlaGames = jsonObj.get("totlaGames"); 
		 
		 
		 long gameID = matchesList.get(0).getGameId();

		 
		//경기정보
		model.addAttribute("matchesList",matchesList);
		 
		 //----------------------------------------------------------------------// 
		 //게임 기록정보	
		 String jsonString5=riotApi.riotAPI("https://kr.api.riotgames.com/lol/match/v4/matches/"+gameID); 
		
		 JsonObject jsonObj2 = (JsonObject) jsonParse.parse(riotApi.riotAPI("https://kr.api.riotgames.com/lol/match/v4/matches/"+gameID));
		 
		 logger.info(jsonObj2.toString());
		 
		 List<TeamStatsDTO> gameList = gson.fromJson(jsonObj2.get("teams"), new TypeToken<List<TeamStatsDTO>>() {}.getType());


		
		model.addAttribute("totlaGames",totlaGames);	
//		model.addAttribute("gameList",gameList);
		
		//레드팀
		Map<String,Object> RedTeam = new HashMap<String,Object>();
		
		RedTeam.put("win", gameList.get(0).getWin());
		RedTeam.put("Tower", gameList.get(0).getTowerKills());
		RedTeam.put("Dragon", gameList.get(0).getDragonKills());
		RedTeam.put("Baron", gameList.get(0).getBaronKills());
		
		//블루팀
		Map<String,Object> BlueTeam = new HashMap<String,Object>();
		
		BlueTeam.put("win", gameList.get(1).getWin());
		BlueTeam.put("Tower", gameList.get(1).getTowerKills());
		BlueTeam.put("Dragon", gameList.get(1).getDragonKills());
		BlueTeam.put("Baron", gameList.get(1).getBaronKills());

		model.addAttribute("RedTeam",RedTeam);
		model.addAttribute("BlueTeam",BlueTeam);
		
		
		  
		return "search/search";
	
	}
}
