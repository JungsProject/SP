package com.myproject.service;

import com.myproject.domain.MemberVO;

public interface MemberService {
	
	// 회원가입
	public void join(MemberVO vo) throws Exception;

}
