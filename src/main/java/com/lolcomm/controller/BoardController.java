package com.lolcomm.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lolcomm.domain.BoardVO;
import com.lolcomm.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/regist", method=RequestMethod.GET)
	private void registGET() throws Exception{
		
		logger.info(" registGET 호출 @@");
		logger.info(" 서비스 객체 @@" + service);
		logger.info(" ./board/regist.jsp 호출 @@");
		
	}
	
	@RequestMapping(value = "/regist", method=RequestMethod.POST)
	private String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		
		logger.info(" registPOST 호출 @@");
		logger.info(" board 객체 @@ " + board);
		
		service.regist(board);
		logger.info(" @@글 저장완료 다음 페이지 호출 @@");
		
		rttr.addFlashAttribute("result", "Success");
		
		return "/board/success";
		
	}
	
	
}
