package com.yedam.app;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class BoardTest {

	@Autowired
	BoardMapper boardMapper;
	
	//전체조회
	@Test
	public void selectAll() {
		List<BoardVO> list = boardMapper.selectBoardList();
		assertTrue(!list.isEmpty());
	}
	
	
	//등록
	@Test
	public void insertInfo() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(1002);
		boardVO.setTitle("제목2");
		boardVO.setContents("님얼굴");
		boardVO.setWriter("니얼굴");
		boardVO.setImage("test");
		
		int result = boardMapper.insertBoard(boardVO);
		assertNotEquals(result, 0);
	}
}
