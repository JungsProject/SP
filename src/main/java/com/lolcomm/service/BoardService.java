package com.lolcomm.service;

import com.lolcomm.domain.BoardVO;

public interface BoardService {

	//게시판 글쓰기
	public void regist(BoardVO vo) throws Exception;
	
}
