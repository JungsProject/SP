package com.lolcomm.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.lolcomm.domain.MemberVO;

public class AdminDAOImpl implements AdminDAO{
	 
    @Inject        //sql쿼리를 사용하기 위해서 의존성을 주입함
    SqlSession sqlSession;
    
    //회원 강제탈퇴 관련 메소드 구현
    @Override
    public void admin_member_forced_evictionCheck(MemberVO vo) throws Exception{
        
            sqlSession.delete("admin.admin_member_forced_evictionCheck", vo);
 
    }
 
}
