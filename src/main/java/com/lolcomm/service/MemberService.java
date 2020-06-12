package com.lolcomm.service;

import javax.servlet.http.HttpSession;

import com.lolcomm.domain.MemberVO;

public interface MemberService {
	
	// 회원가입
	public void join(MemberVO vo) throws Exception;
	
	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;
	
	// 로그아웃
	public void logout(HttpSession session) throws Exception;
}
