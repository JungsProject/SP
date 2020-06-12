package com.lolcomm.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lolcomm.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = 
			"com.lolcomm.mapper.BoardMapper";
	
	
	@Override
	public void create(BoardVO vo) throws Exception {

		System.out.println("@@ BoardDAOImpl 객체 호출 -> Mapper");
		sqlSession.insert(namespace+".create",vo);
		System.out.println("@@ Mapper에서 sql실행 완료 -> 호출 된곳으로 이동");
		
	}

}
