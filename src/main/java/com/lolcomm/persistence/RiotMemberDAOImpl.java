package com.lolcomm.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lolcomm.domain.RiotMemberLeague;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
@Repository
public class RiotMemberDAOImpl implements RiotMemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = 
			"com.lolcomm.mapper.RiotMemberMapper";
	
	@Override
	public void insertMember(RiotMemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("@@@@@ RiotMemberDAOImpl 객체 호출 -> Mapper 이동 SQL 실행");
		sqlSession.insert(namespace+".insert_user", vo);
		System.out.println("@@@@@ Mapper에서 DB 이동 후 처리 완료 -> 호출된 곳으로 이동");
	}

	@Override
	public void updateMember(RiotMemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("@@@@@ RiotMemberDAOImpl 객체 호출 -> Mapper 이동 SQL 실행");
		sqlSession.insert(namespace+".update_user", vo);
		System.out.println("@@@@@ Mapper에서 DB 이동 후 처리 완료 -> 호출된 곳으로 이동");
	}

	@Override
	public RiotMemberVO selectMember(RiotMemberVO vo) throws Exception {
		System.out.println("@@@@@ RiotMemberDAOImpl 객체 호출 -> Mapper 이동 SQL 실행");
		RiotMemberVO rmvo=sqlSession.selectOne(namespace+".select_user", vo);
		System.out.println("@@@@@ Mapper에서 DB 이동 후 처리 완료 -> 호출된 곳으로 이동");
		return rmvo;
	}


	
	@Override
	public List<RiotMemberVO> selectLevel_Rank(int page) {
		
		List<RiotMemberVO> rmList= sqlSession.selectList(namespace+".select_LevelRank",page);
		for (RiotMemberVO riotMemberVO : rmList) {
			sqlSession.selectOne(namespace+".select_Legue" , riotMemberVO.getId());
		}
		
		return rmList;
	}

	@Override
	public void insertMastery(List<RiotMemberMasteryVO> masteryList) {
		
			sqlSession.insert(namespace+".insert_mastery",masteryList);
			
		
		
	}

	@Override
	public void insertLeague(List<RiotMemberLeague> leagueList) {
		sqlSession.insert(namespace+".insert_league",leagueList);
		
	}

	

}
