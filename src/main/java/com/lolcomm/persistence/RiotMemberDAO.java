package com.lolcomm.persistence;

import java.util.List;

import com.lolcomm.domain.PagingVO;
import com.lolcomm.domain.RiotMemberLeagueRankVO;
import com.lolcomm.domain.RiotMemberLeagueVO;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.domain.RiotRankVO;
import com.lolcomm.domain.ladderVO;
import com.lolcomm.domain.levelRankingVO;

public interface RiotMemberDAO {
	
	public void insertMember(RiotMemberVO vo) throws Exception;
	
	public void updateMember(RiotMemberVO vo) throws Exception;
	
	public RiotMemberVO selectMember(RiotMemberVO vo) throws Exception;



	

	public void insertMastery(List<RiotMemberMasteryVO> masteryList);

	public List<levelRankingVO> selectLevel_Rank(int page);

	public void insertLeague(List<RiotMemberLeagueVO> leagueList);

	public void insertTierLeague(RiotRankVO tier);

	public List<ladderVO> select_ladder(PagingVO vo);

	public int ladderCount();

}
