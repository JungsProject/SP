package com.lolcomm.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lolcomm.domain.UserQuizVO;
import com.lolcomm.persistence.UserQuizDAO;

@Service
public class UserQuizServiceImpl implements UserQuizService {
	
	@Inject
	private UserQuizDAO uqdao;
	
	@Override
	public void regist(UserQuizVO vo) throws Exception {
		// 유저퀴즈 등록
		System.out.println("@@@ Service 계층 퀴즈등록 동작 실행 -> DAO 메서드 호출");
		uqdao.create(vo);
		System.out.println("@@@ DAO 에서 유저퀴즈 등록 처리 완료!");
		
	}

}
