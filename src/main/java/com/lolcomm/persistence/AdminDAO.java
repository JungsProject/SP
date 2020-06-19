package com.lolcomm.persistence;

import java.util.List;

import com.lolcomm.domain.MemberVO;

public interface AdminDAO {
	 	 
  public void admin_delete(MemberVO vo) throws Exception;    //회원 강제탈퇴 관련 메소드

  List<MemberVO> member_info(String id) throws Exception; 	//회원정보 확인하는 메소드
}
