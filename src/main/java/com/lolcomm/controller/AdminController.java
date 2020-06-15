package com.lolcomm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	    
	  // 관리자 로그인시 관리자 메인페이지로 이동  
	  @RequestMapping(value="/adminPage", method=RequestMethod.GET)  
	  private void adminPage_GET ()throws Exception{
		  logger.info(" adminPage_GET 호출 @@");
	  }
	  @RequestMapping(value="/adminPage", method=RequestMethod.POST)  
	  private void adminPage_POST ()throws Exception{
		  logger.info(" adminPage_POST 호출 @@");
	  }
	
	  //관리자로 로그인한 후에 회원정보 버튼을 누르면 맵핑되는 메소드 회원정보 페이지로 이동시킨다.
	  @RequestMapping(value = "/member_info", method=RequestMethod.GET)
	  private void member_info_GET () throws Exception {
		  
		  logger.info(" member_info_GET 호출 @@");
	  }
	  @RequestMapping(value = "/member_info", method=RequestMethod.POST)
	  private void member_info_POST () throws Exception {
		  
		  logger.info(" member_info_POST 호출 @@");
	  }
	  
	  // 회원 아이디로 해당 회원의 정보를 검색하는 메소드
	  @RequestMapping(value="/find_member_info", method= {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView find_member_info(String id, MemberVO vo, Date reg_date) throws Exception{
	        
	        //데이터베이스에서 검색한 값들을 DTO타입에 LIST에 저장한다.
	        java.util.List<MemberVO> list = adminservice.find_member_info(id);     //넘길 데이터가 많기 때문에        
	        
	        Map<String,Object> map = new HashMap<>();
	        
	        
	        //map에 리스트를 저장해서 출력할 view로 이동시킨다.
	        //list가 null이면 회원정보가 없는것이므로 경고창을 출력하도록 함	        
	        ModelAndView mv = new ModelAndView();
	        
	        //if문에서 list null처리를 할때에는 isEmpty()를 사용해서 null체크후 처리를 해주어야 한다.
	        //list안에 값이 들어있을때 실행되는 구문
	        if(!list.isEmpty()) {
	            
	            //reg_date의 형식을 바꾸어야 하기 때문에 reg_date만 따로 빼서 형식을 변경한 후에 따로 넘긴다.
	            for (int i = 0; i<list.size(); i++) {	                
	                reg_date = list.get(i).getReg_date();	                
	            }	            
	            String re_reg_date = new SimpleDateFormat("yyyy-MM-dd").format(reg_date);
	            
	            map.put("re_reg_date", re_reg_date);	            
	            map.put("list", list);	            
	            mv.addObject("map",map);	            
	            mv.setViewName("admin/member_info");
	            
	        }else {	            
	            mv.addObject("message", "회원정보가 없는 회원입니다.");	            
	            mv.setViewName("admin/member_info");
	        }       	        
	        return mv;
	    }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
