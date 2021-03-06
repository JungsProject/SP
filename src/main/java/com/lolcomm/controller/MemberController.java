package com.lolcomm.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lolcomm.domain.MemberVO;
import com.lolcomm.service.MemberService;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스 객체 (의존 주입)
	@Inject
	private MemberService service;
	
	/*
	 * public void loginGET() throws Exception { logger.info("@@@ /login 주소 호출"); }
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() throws Exception {
		logger.info("@@@ /login 주소 호출");
		logger.info("@@@ 컨트롤러 loginGET() 호출");
		logger.info("./member/login.jsp 페이지 호출");
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		
		HttpSession session = req.getSession();
		
		logger.info("### /login 주소 호출");
		logger.info("### /컨트롤러 loginPOST() 호출");
		
		MemberVO login = service.login(vo);
		
		System.out.println("@@@컨트롤러 : 로그인 처리 완료!");
		
		if(login == null) {
			// 로그인 실패
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			System.out.println(login + "로그인 실패");
			return "redirect:/member/login";
		} else {
			session.setAttribute("member", login);
			System.out.println(login + "로그인 성공");
			
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		logger.info("get logout");
		
		service.logout(session);
		
		return "redirect:/";
	}
	
	// @RequestMapping(value = "매핑될 주소값",method = 호출방식)
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void joinGET() throws Exception {
		logger.info("@@@ /join 주소 호출");
		logger.info("@@@ 컨트롤러 joinGET() 호출");
		logger.info("./member/join.jsp 페이지 호출");
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO vo) throws Exception {
		logger.info("### /join 주소 호출");
		logger.info("### /컨트롤러 joinPOST() 호출");
		logger.info("member : " + vo);
		
		service.join(vo);
		System.out.println("@@@컨트롤러 : 회원가입완료!");
		
		return "redirect:/member/login";
	}

}
