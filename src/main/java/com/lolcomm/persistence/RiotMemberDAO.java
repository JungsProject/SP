package com.lolcomm.persistence;

import java.util.List;

import com.lolcomm.domain.RiotMemberLeague;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;

public interface RiotMemberDAO {
	
	public void insertMember(RiotMemberVO vo) throws Exception;
	
	public void updateMember(RiotMemberVO vo) throws Exception;
	
	public RiotMemberVO selectMember(RiotMemberVO vo) throws Exception;



	

	public void insertMastery(List<RiotMemberMasteryVO> masteryList);

	public List<RiotMemberVO> selectLevel_Rank(int page);

	public void insertLeague(List<RiotMemberLeague> leagueList);
}
