package com.lolcomm.persistence;

import com.lolcomm.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입
	public void join(MemberVO vo) throws Exception;

}
