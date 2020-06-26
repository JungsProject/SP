package com.lolcomm.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lolcomm.domain.PageMakerVO;
import com.lolcomm.domain.RiotMemberLeagueRankVO;
import com.lolcomm.domain.RiotMemberLeagueVO;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.domain.RiotRankVO;
import com.lolcomm.domain.ladderVO;
import com.lolcomm.domain.levelRankingVO;
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
	public List<levelRankingVO> selectLevel_Rank(int page) {
		
		List<levelRankingVO> rmList= sqlSession.selectList(namespace+".select_LevelRank",page);
		
		
		return rmList;
	}

	@Override
	public void insertMastery(List<RiotMemberMasteryVO> masteryList) {
		
			sqlSession.insert(namespace+".insert_mastery",masteryList);
			
		
		
	}

	@Override
	public void insertLeague(List<RiotMemberLeagueVO> leagueList) {
		sqlSession.insert(namespace+".insert_league",leagueList);
		
	}

	@Override
	public void insertTierLeague(RiotRankVO tier) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insert_rank_league",tier);
	}

	@Override
	public List<ladderVO> select_ladder(PageMakerVO vo) {
		// TODO Auto-generated method stub
		
		List<ladderVO> ranking=sqlSession.selectList(namespace+".select_ladder",vo);
		
		return ranking;
	}

	@Override
	public int ladderCount() {
		int count= sqlSession.selectOne(namespace+".countladder");
		return count;
	}


	

}
