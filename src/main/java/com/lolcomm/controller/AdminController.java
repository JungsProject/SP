package com.lolcomm.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lolcomm.domain.MemberVO;
import com.lolcomm.service.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	 
	private static final Logger logger= 
		        LoggerFactory.getLogger(MemberController.class);  //로깅을 위한 변수
		        
	 @Inject    //서비스를 호출하기 위해서 의존성을 주입	   
	 private AdminService adminservice;
	    
	    //관리자로 로그인 후에 강제 탈퇴시킬 회원의 아이디를 입력후 강제탈퇴 버튼을 누르면 연결되는 메소드
	    @RequestMapping(value="/admin_delete", method=RequestMethod.GET)
	    private void admin_delete_GET (String id) throws Exception{
	        
			logger.info(" admin_delete_GET 호출 @@");
			logger.info(" 서비스 객체 @@" + adminservice);
			logger.info(" ./admin/admin_delete.jsp 호출 @@");   
	    }
	    
	    @RequestMapping(value="/admin_delete", method=RequestMethod.POST)
	    private void admin_delete_POST (MemberVO vo) throws Exception{
	    	
	    	logger.info(" 서비스 객체 @@" + vo);
	    	
	    	//유저의 아이디를 삭제 (강제탈퇴) 시키기위해서 vo에 담는다.
	    	
	    	//회원탈퇴 체크를 하기위한 메소드, 탈퇴 시키려는 회원의 아이디가 있는지 검사한후에 result 변수에 저장한다.
	    	adminservice.admin_delete(vo);
	    	System.out.println("@@@회원 강제탈퇴 완료!");
	    	
	    }
	
}
