package com.icia.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	private ModelAndView mav;

	// 글쓰기 화면을 띄우는 메소드
	@RequestMapping(value="/writepage")
	public String writePage() {	
		return "boardwrite";
	}
	
	// 글쓰기 처리를 하는 메소드
	@RequestMapping(value="/boardwrite")
	public ModelAndView boardwrite(@ModelAttribute BoardDTO board) {
		mav = bs.boardwrite(board);
		// 글쓰기 발행(성공) 시, 글목록 출력되도록 
		return mav;
	}
	
	@RequestMapping(value="/boardlist")
	public ModelAndView boardList() {
		mav = bs.boardList();
		return mav;
	}
	
	
	
	
	
}
