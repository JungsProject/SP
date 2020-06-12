package com.lolcomm.persistence;

import com.lolcomm.domain.BoardVO;

public interface BoardDAO {
	
	//글 작성
	public void create(BoardVO vo) throws Exception;

}
