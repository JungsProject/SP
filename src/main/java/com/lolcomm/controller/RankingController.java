package com.lolcomm.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.lolcomm.api.RiotAPI;
import com.lolcomm.domain.PagingVO;
import com.lolcomm.domain.RiotMemberLeagueRankVO;
import com.lolcomm.domain.RiotMemberLeagueVO;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.domain.RiotRankVO;
import com.lolcomm.domain.ladderVO;
import com.lolcomm.domain.levelRankingVO;
import com.lolcomm.service.RiotMemberService;

@Controller
@RequestMapping("/ranking/*")
public class RankingController {
	
	private static final Logger logger = LoggerFactory.getLogger(RankingController.class);
	@Inject
	private RiotMemberService rmservice;
	
	
	@Scheduled(fixedDelay=216000000)
	public void ladderUpdate() {
		logger.info("ranking update");
		Gson gson =new Gson();
		RiotAPI riotApi =new RiotAPI();
		String jsonString= riotApi.riotAPI("https://kr.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5");
		RiotRankVO challenger= gson.fromJson(jsonString, RiotRankVO.class);
		
		rmservice.insertTierLeague(challenger);
		String jsonString2 = riotApi.riotAPI("https://kr.api.riotgames.com/lol/league/v4/grandmasterleagues/by-queue/RANKED_SOLO_5x5");
		RiotRankVO grandMaster= gson.fromJson(jsonString2, RiotRankVO.class);
		rmservice.insertTierLeague(grandMaster);
		String jsonString3 = riotApi.riotAPI("https://kr.api.riotgames.com/lol/league/v4/masterleagues/by-queue/RANKED_SOLO_5x5");
		RiotRankVO master= gson.fromJson(jsonString3, RiotRankVO.class);
		rmservice.insertTierLeague(master);
		logger.info("MASTER 티어 까지 랭킹정보 업데이트 완료!");
	}
	
	
	@RequestMapping(value="/ladder",  method= RequestMethod.GET)
	public void noladder(Model model) throws Exception{
		ladder(1, model);
	}
	
	
	@RequestMapping(value = "/ladder/{page}", method = RequestMethod.GET)
	public String ladder(@PathVariable("page") int page,Model model) throws Exception {
		int total= rmservice.ladderCount();
		PagingVO pagingVO =new PagingVO(total,page,100);
		List<ladderVO> ranking=rmservice.select_ladder(pagingVO);
		logger.info(ranking.toString());
		model.addAttribute("rankList",ranking);
		model.addAttribute("pagingVO",pagingVO);
		logger.info(ranking.toString());
		logger.info("@@@ /ladder get 주소 호출");
		logger.info("@@@ 컨트롤러 ladder() 호출");
		logger.info("./ranking/ladder.jsp 페이지 호출");
		
		return "ranking/ladder";
	}
	@RequestMapping(value = "/champions", method = RequestMethod.GET)
	public void champions() throws Exception {
		logger.info("@@@ /champions get 주소 호출");
		logger.info("@@@ 컨트롤러 champions() 호출");
		logger.info("./ranking/champions.jsp 페이지 호출");
	}
	@RequestMapping(value = "/level", method = RequestMethod.GET)
	public void level(Model model) throws Exception {
		
		List<levelRankingVO> rmList=(List<levelRankingVO>) rmservice.getLevel_Rank();
		
		model.addAttribute("rmList",rmList);
		logger.info("@@@ /level get 주소 호출");
		logger.info("@@@ 컨트롤러 level() 호출");
		logger.info("./ranking/level.jsp 페이지 호출");
	}
}
