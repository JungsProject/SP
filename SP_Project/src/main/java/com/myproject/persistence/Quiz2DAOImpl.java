package com.myproject.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class Quiz2DAOImpl implements Quiz2DAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = 
			"com.myproject.mapper.Quiz2Mapper";

}
