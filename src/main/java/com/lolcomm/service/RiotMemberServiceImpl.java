package com.lolcomm.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lolcomm.domain.RiotMemberLeague;
import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;
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
	public List<RiotMemberVO> getLevel_Rank() {
		// TODO Auto-generated method stub
		List<RiotMemberVO> rmList=rmdao.selectLevel_Rank(0);
		
		return rmList;
	}
	@Override
	public void insertLeague(List<RiotMemberLeague> leagueList) {
		// TODO Auto-generated method stub
		rmdao.insertLeague(leagueList);
	}


}
