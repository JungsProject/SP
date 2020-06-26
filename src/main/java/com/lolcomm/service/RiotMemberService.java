package com.lolcomm.service;

import java.util.List;

import com.lolcomm.domain.PageMakerVO;
import com.lolcomm.domain.RiotMemberLeagueRankVO;
import com.lolcomm.domain.RiotMemberLeagueVO;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.domain.RiotRankVO;
import com.lolcomm.domain.ladderVO;
import com.lolcomm.domain.levelRankingVO;

public interface RiotMemberService {
	
	public void insertMember(RiotMemberVO vo) throws Exception;

	public void insertMastery(List<RiotMemberMasteryVO> masteryList);

	public List<levelRankingVO> getLevel_Rank();

	void insertLeague(List<RiotMemberLeagueVO> leagueList);

	public void insertTierLeague(RiotRankVO tier);

	public List<ladderVO> select_ladder(PageMakerVO vo);
	//리그 회원아이디 가져오기

	public int ladderCount();
	
}
