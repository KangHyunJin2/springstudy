package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//전체조회 : URI - boardList / RETURN - board?boardList
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		List<BoardVO> list = boardService.getBoardAll();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
	//단건조회 : URI - boardInfo / PARAMETER - BOARDVO
	//		   / RETURN - board/boardInfo
	@GetMapping("boardInfo") // boardMapper.xml 에서 bno 값을 넘김
	public String getBoardInfo(BoardVO boardVO, Model  model) { // 커멘드 객체 기반으로 작업
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardInfo";
	}
	
	//등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}
	
	//등록 - 처리   : URI - boardInsert / PARAMETER - boardVO
	//			/ RETURN - 전체조히 다시 호출
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";
		
	}
	
	
	//수정 - 페이지  : URI - boardUpdate / PARAMETER - BoardVO
	// 			/ RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model){
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardUpdate";
	}
	
	//수정 - 처리    : URI - boardUpdate / PARAMETER - BoardVO
	//			/ RETURN - 수정결과 데이터(Map)
	@PostMapping("boardUpdate") // 아작스 용
	@ResponseBody 									
	public Map<String, Object> boardUpdateAjaxProcess(@RequestBody BoardVO boardVO, Model model){ // @Requestbody를 쓰느냐 안쓰느냐 상관은 없다 하지만 아작스 기반으로 하게되면 content 타입이 달라진다
		return boardService.updateBoardInfo(boardVO);								 // @Requestbody를 쓰면 boardUpdate에서 
																					//contentType : 'application/json',
																					//data : JSON.stringify(boardDta)
	}
	
	//삭제
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam Integer bno) { //RequestParam 은 붙이는 순간 필수값이다 데이터가 넘어 오지 않으면 통신 자체를 거부함 
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
	}
	
}
