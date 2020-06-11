package com.myproject.persistence;

import com.myproject.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입
	public void join(MemberVO vo) throws Exception;

}
