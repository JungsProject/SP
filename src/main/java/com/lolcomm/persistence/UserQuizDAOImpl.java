package com.lolcomm.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lolcomm.domain.UserQuizVO;

@Repository
public class UserQuizDAOImpl implements UserQuizDAO {
	
	@Inject
	private SqlSession sqlSession; 
	
	private static final String namespace =
			"com.lolcomm.mapper.UserQuizMapper";

	@Override
	public void create(UserQuizVO vo) throws Exception {
		// 유저퀴즈 등록
		System.out.println("@@@ UserQuizDAOImpl 객체 호출 -> Mapper이동 SQL 실행");
		sqlSession.insert(namespace+".create", vo);
		System.out.println("@@@ Mapper에서 Mysql 이동 후 처리 완료 -> 호출된 곳으로 이동");
		
	}

}
