package com.lolcomm.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lolcomm.domain.MemberVO;


@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// DB 접속
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = 
			"com.lolcomm.mapper.MemberMapper";
	
	@Override
	public void join(MemberVO vo) throws Exception {
		// 회원가입
		System.out.println("@@@@@ MemberDAOImpl 객체 호출 -> Mapper 이동 SQL 실행");
		sqlSession.insert(namespace+".join", vo);
		System.out.println("@@@@@ Mapper에서 DB 이동 후 처리 완료 -> 호출된 곳으로 이동");
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		// 로그인
		System.out.println("@@@@@ MemberDAOImpl 객체 호출 -> Mapper 이동 SQL 실행");
		
		return sqlSession.selectOne(namespace+".login", vo);
	}

}
