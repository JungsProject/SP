package com.lolcomm.persistence;

import com.lolcomm.domain.MemberVO;

public interface AdminDAO {
	 	 
  public void admin_member_forced_evictionCheck(MemberVO vo) throws Exception;    //회원 강제탈퇴 관련 메소드
 
}