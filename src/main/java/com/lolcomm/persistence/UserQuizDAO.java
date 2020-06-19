package com.lolcomm.persistence;

import com.lolcomm.domain.UserQuizVO;

public interface UserQuizDAO {
	
	// 유저퀴즈 등록
	public void create(UserQuizVO vo) throws Exception;

}
