package com.lolcomm.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.lolcomm.domain.MemberVO;
import com.lolcomm.persistence.AdminDAO;

@Service	// 서비스 빈으로 설정함
public class AdminServieceImpl implements AdminService{
	  
    @Inject    //dao를 호출하기때문에 의존성을 주입한다.
    AdminDAO adao;
    
//    @Override    //로그인 체크 관련 메소드 (세션에 아이디와 비밀번호를 저장함)
//    public boolean loginCheck(MemberVO vo, HttpSession session) throws Exception {
//        
//        boolean result = adao.loginCheck(vo);
//        
//        if(result) {    //로그인 성공
//            
//            session.setAttribute("id", vo.getId());
//            session.setAttribute("pass", vo.getPass());
//            
//        }
//        
//        return result;
//    }
    
    //회원 강제탈퇴 관련 메소드
    @Override
    public void admin_member_forced_evictionCheck(MemberVO vo) throws Exception{
 
        adao.admin_member_forced_evictionCheck(vo);
        
    }
 
}
