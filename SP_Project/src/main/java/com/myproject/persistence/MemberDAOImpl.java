package com.myproject.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myproject.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// DB 접속
	private SqlSession sqlSession;
	
	private static final String namespace = 
			"com.myproject.mapper.MemberMapper";
	
	@Override
	public void join(MemberVO vo) throws Exception {
		// 회원가입
		System.out.println("@@@@@ MemberDAOImpl 객체 호출 -> Mapper 이동 SQL 실행");
		sqlSession.insert(namespace+".join", vo);
		System.out.println("@@@@@ Mapper에서 DB 이동 후 처리 완료 -> 호출된 곳으로 이동");
	}

}
