package com.icia.board.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO bdao;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;
	
	public ModelAndView boardwrite(BoardDTO board) {
		mav = new ModelAndView();
		int writeResult = bdao.boardWrite(board);

		// 글쓰기 성공: 목록 출력 (목록출력을 담당하는 컨트롤러의 주소를 요청해야함.)
		// 글쓰기 실패: boardwrite.jsp 를 띄움.
		if(writeResult > 0) {
			mav.setViewName("redirect:/boardlist");
		} else {
			mav.setViewName("boardwrite");
		}
		
		return mav;
	}
	
	public ModelAndView boardList() {
		mav = new ModelAndView();
		List<BoardDTO> boardList = bdao.boardList();
		
		mav.addObject("boardList", boardList);
		mav.setViewName("boardlist");
		
		return mav;
	}

	public ModelAndView boardView(int bnumber) {
		mav = new ModelAndView();
		// 1. 해당 글의 조회수 값 1증가 (update 쿼리)
		// 2. 해당 글의 내용 가져오기 (select 쿼리)
		bdao.boardhits(bnumber);
		
		BoardDTO board = bdao.boardView(bnumber);
		
		mav.addObject("board", board);
		mav.setViewName("boardview");
		return mav;
	}
	
	public ModelAndView boardupdate() {
		mav = new ModelAndView();
		List<BoardDTO> boardupdate = bdao.boardupdate();
		mav.addObject("boardUpdate", boardupdate);
		mav.setViewName("boardupdate");
		
		return mav;
	}
	
	public ModelAndView updateProcess(BoardDTO board) {
		mav = new ModelAndView();
		int updateResult = bdao.updateProcess(board);
		if(updateResult > 0) {
			mav.setViewName("boarlist");
		} else {
			mav.setViewName("updatefail");
		}
		return mav;
	}
	
}
