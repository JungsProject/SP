package com.lolcomm.persistence;

import com.lolcomm.domain.RiotMemberMasteryVO;
import com.lolcomm.domain.RiotMemberVO;

public interface RiotMemberDAO {
	
	public void insertMember(RiotMemberVO vo) throws Exception;
	
	public void updateMember(RiotMemberVO vo) throws Exception;
	
	public RiotMemberVO selectMember(RiotMemberVO vo) throws Exception;

	public boolean selectMastery(RiotMemberMasteryVO riotMemberMasteryVO);

	public void updateMastery(RiotMemberMasteryVO riotMemberMasteryVO);

	public void insertMasery(RiotMemberMasteryVO riotMemberMasteryVO);
}
