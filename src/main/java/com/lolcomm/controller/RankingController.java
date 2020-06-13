package com.lolcomm.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lolcomm.domain.RiotMemberLeague;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.service.RiotMemberService;

@Controller
@RequestMapping("/ranking/*")
public class RankingController {

	private static final Logger logger = LoggerFactory.getLogger(RankingController.class);
	@Inject
	private RiotMemberService rmservice;
	@RequestMapping(value = "/ladder", method = RequestMethod.GET)
	public void ladder() throws Exception {
		logger.info("@@@ /ladder get 주소 호출");
		logger.info("@@@ 컨트롤러 ladder() 호출");
		logger.info("./ranking/ladder.jsp 페이지 호출");
	}
	@RequestMapping(value = "/champions", method = RequestMethod.GET)
	public void champions() throws Exception {
		logger.info("@@@ /champions get 주소 호출");
		logger.info("@@@ 컨트롤러 champions() 호출");
		logger.info("./ranking/champions.jsp 페이지 호출");
	}
	@RequestMapping(value = "/level", method = RequestMethod.GET)
	public void level(Model model) throws Exception {
		
		List<RiotMemberVO> rmList=(List<RiotMemberVO>) rmservice.getLevel_Rank();
		
		model.addAttribute("rmList",rmList);
		logger.info("@@@ /level get 주소 호출");
		logger.info("@@@ 컨트롤러 level() 호출");
		logger.info("./ranking/level.jsp 페이지 호출");
	}
}
