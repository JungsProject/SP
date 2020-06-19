package com.lolcomm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.lolcomm.domain.MemberVO;

public interface AdminService {
	  	 
	public void admin_delete(MemberVO vo) throws Exception; //강제탈퇴 시킬때 해당 회원이 있는지 체크하는 메소드
	 
	List<MemberVO> find_member_info(String id) throws Exception;	//회원정보를 찾는 메소드    
}
