package com.lolcomm.persistence;

import com.lolcomm.domain.MemberVO;

public interface AdminDAO {
	 	 
  public void admin_delete(MemberVO vo) throws Exception;    //회원 강제탈퇴 관련 메소드

 
}
