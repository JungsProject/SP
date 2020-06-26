package com.lolcomm.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lolcomm.domain.PagingVO;
import com.lolcomm.domain.RiotMemberLeagueRankVO;
import com.lolcomm.domain.RiotMemberLeagueVO;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
import com.lolcomm.domain.RiotRankVO;
import com.lolcomm.domain.ladderVO;
import com.lolcomm.domain.levelRankingVO;
import com.lolcomm.persistence.RiotMemberDAO;
@Service
public class RiotMemberServiceImpl implements RiotMemberService {
	//의존 주입
	@Inject
	private RiotMemberDAO rmdao;
	@Override
	public void insertMember(RiotMemberVO vo) throws Exception {
		RiotMemberVO rmvo=rmdao.selectMember(vo);//회원정보 있는지 여부 확인
		if(rmvo != null) 
			rmdao.updateMember(vo);	//회원정보 있을경우
		else 
			rmdao.insertMember(vo);	//회원정보 없을경우
		
		
	}
	@Override
	public void insertMastery(List<RiotMemberMasteryVO> masteryList) {
		rmdao.insertMastery(masteryList);

	}
	@Override
	public List<levelRankingVO> getLevel_Rank() {
		// TODO Auto-generated method stub
		List<levelRankingVO> rmList=rmdao.selectLevel_Rank(0);
		
		
		return rmList;
	}
	@Override
	public void insertLeague(List<RiotMemberLeagueVO> leagueList) {
		// TODO Auto-generated method stub
		rmdao.insertLeague(leagueList);
	}
	@Override
	public void insertTierLeague(RiotRankVO tier) {
		// TODO Auto-generated method stub
		List<RiotMemberLeagueVO> entries= tier.getEntries();
		
		Comparator<RiotMemberLeagueVO> sortComparator= new Comparator<RiotMemberLeagueVO>() {
			
			@Override
			public int compare(RiotMemberLeagueVO o1, RiotMemberLeagueVO o2) {
				if(o1.getLeaguePoints()>o2.getLeaguePoints())
					return -1;
				else if(o2.getLeaguePoints()>o1.getLeaguePoints())
					return 1;
				else 
					return 0;
			}
		};
		Collections.sort(entries, sortComparator);
		tier.setEntries(entries);
		rmdao.insertTierLeague(tier);
		
	}
	@Override
	public List<ladderVO> select_ladder(PagingVO vo) {
		// TODO Auto-generated method stub
		List<ladderVO> ranking=rmdao.select_ladder(vo);
		return ranking;
	}
	@Override
	public int ladderCount() {
		int count= rmdao.ladderCount();
		return count;
	}


}
