package com.lolcomm.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.lolcomm.domain.MemberVO;
import com.lolcomm.persistence.AdminDAO;

@Service	// 서비스 빈으로 설정함
public class AdminServieceImpl implements AdminService{
	  
    @Inject    //dao를 호출하기때문에 의존성을 주입한다.
    private AdminDAO adao;
    
    //회원 강제탈퇴 관련 메소드
    @Override
    public void admin_member_forced_evictionCheck(MemberVO vo) throws Exception{
 
        adao.admin_member_forced_evictionCheck(vo);
        
    }
 
}
