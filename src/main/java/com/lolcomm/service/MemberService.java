package com.lolcomm.service;

import com.lolcomm.domain.MemberVO;

public interface MemberService {
	
	// 회원가입
	public void join(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;

}
