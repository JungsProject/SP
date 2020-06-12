package com.lolcomm.persistence;

import com.lolcomm.domain.MemberVO;

public interface AdminDAO {

	boolean loginCheck(MemberVO vo) throws Exception;    //로그인을 체크하는 메소드
	 
	 
    void admin_member_forced_evictionCheck(MemberVO vo) throws Exception;    //회원 강제탈퇴 관련 메소드
 
}
