package com.lolcomm.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lolcomm.domain.MemberVO;
import com.lolcomm.persistence.MemberDAO;


@Service
public class MemberServiceImpl implements MemberService {
	
	// DAO 객체 (의존 주입)
	@Inject
	private MemberDAO mdao;
	
	@Override
	public void join(MemberVO vo) throws Exception {
		// 회원가입
		System.out.println("@@@@@ Service 계층 회원가입 동작 실행 -> DAO 메서드 호출");
		mdao.join(vo);
		System.out.println("@@@@@ DAO 에서 회원가입 처리 완료!");
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		// 로그인
		System.out.println("@@@@@ Service 계층 로그인 동작 실행 -> DAO 메서드 호출");
		
		return mdao.login(vo);
	}

}
