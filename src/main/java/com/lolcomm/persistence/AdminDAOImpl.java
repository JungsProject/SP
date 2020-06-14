package com.lolcomm.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lolcomm.domain.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO{
	 
    @Inject        //sql쿼리를 사용하기 위해서 의존성을 주입함
    private SqlSession sqlSession;
    
	private static final String namespace = 
			"com.lolcomm.mapper.adminMapper";
    
    //회원 강제탈퇴 관련 메소드 구현
    @Override
    public void admin_delete(MemberVO vo) throws Exception{
        
            sqlSession.delete(namespace+".delete", vo);
 
    }
 
}
