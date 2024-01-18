package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	//전체조회
	public List<BoardVO> selectBoardList();

	//단건조회 : 조건 - bno 어 떤경우라도 한건만 돌아 와야함 단일 클래스
	public BoardVO selectBoard(BoardVO boardVO);
	
	// 등록 수정 삭제 무조건 정수타입으로 돌아옴
	//등록    : 대상 - bno(selectkey), title, contents, writer, image
	public int insertBoard(BoardVO boardVO);
	
	//수정	 : 대상 - title, contents, writer, updatedate, image
	public int updateBoard(BoardVO boardVO);
	
	//삭제	 : 조건 - bno
	public int deleteBoard(int boardNo);
}
