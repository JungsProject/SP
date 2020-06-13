package com.lolcomm.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.lolcomm.domain.MemberVO;

public class AdminDAOImpl implements AdminDAO{
	 
    @Inject        //sql쿼리를 사용하기 위해서 의존성을 주입함
    SqlSession sqlSession;
    
    //로그인 체크
    //id가 null이면 false를 리턴하고 값이 있으면 true를 리턴한다.
//    @Override
//    public boolean loginCheck(MemberVO vo) throws Exception{
//        
//        String name = sqlSession.selectOne("admin.login_check", vo);
//        
//        //조건식 ? true일때의 값 : false일때의 값
//        return (name==null) ? false : true;
//        
//    }
    
    //회원 강제탈퇴 관련 메소드 구현
    @Override
    public void admin_member_forced_evictionCheck(MemberVO vo) throws Exception{
        
            sqlSession.delete("admin.admin_member_forced_evictionCheck", vo);
 
    }
 
}
