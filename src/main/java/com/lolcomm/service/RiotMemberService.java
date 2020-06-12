package com.lolcomm.service;

import java.util.List;

import com.lolcomm.domain.RiotMemberLeague;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;

public interface RiotMemberService {
	
	public void insertMember(RiotMemberVO vo) throws Exception;

	public void insertMastery(List<RiotMemberMasteryVO> masteryList);

	public List<RiotMemberVO> getLevel_Rank();

	public void insertLeague(List<RiotMemberLeague> leagueList);

}
