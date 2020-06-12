package com.lolcomm.persistence;

import com.lolcomm.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입
	public void join(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;

}
