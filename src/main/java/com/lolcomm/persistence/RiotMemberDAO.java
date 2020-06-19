package com.lolcomm.persistence;

import java.util.List;

import com.lolcomm.domain.RiotMemberLeague;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.domain.levelRankingVO;

public interface RiotMemberDAO {
	
	public void insertMember(RiotMemberVO vo) throws Exception;
	
	public void updateMember(RiotMemberVO vo) throws Exception;
	
	public RiotMemberVO selectMember(RiotMemberVO vo) throws Exception;



	

	public void insertMastery(List<RiotMemberMasteryVO> masteryList);

	public List<levelRankingVO> selectLevel_Rank(int page);

	public void insertLeague(List<RiotMemberLeague> leagueList);
}
