package com.lolcomm.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.lolcomm.domain.BoardVO;
import com.lolcomm.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO bdao;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		
		System.out.println("@@ Service 계층 글 작성 실행 @@");
		bdao.create(vo);

	}

}
