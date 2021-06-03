package com.icia.memberboard.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memberboard.dto.BoardDTO;
import com.icia.memberboard.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;
	
	// 글목록
	@RequestMapping(value="/boardlist")
	public ModelAndView boardList() {
		mav = bs.boardList();
		return mav;
	}
	
	// 글쓰기 화면
	@RequestMapping(value="/writepage")
	public String writePage() {	
		return "boardwrite";
	}
	
	// 글쓰기 처리
	@RequestMapping(value="/boardwrite")
	public ModelAndView boardWrite(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		mav = bs.boardWrite(board);
		return mav;
	}
	// 글조회
	@RequestMapping(value="/boardview")
	public ModelAndView boardView(@RequestParam("bnumber") int bnumber) {
		mav = bs.boardView(bnumber);
		return mav;
	}
	//글 수정화면
	@RequestMapping(value="/boardupdate")
	public ModelAndView boardUpdate(@RequestParam("bnumber") int bnumber) {
		mav = bs.boardUpdate(bnumber);
		return mav;
	}
	// 글수정 처리 
	@RequestMapping(value="/bupdateprocess")
	public ModelAndView updateProcess(@ModelAttribute BoardDTO board) {
		mav = bs.updateProcess(board);
		return mav;
	}
	// 글삭제 처리
	@RequestMapping(value="/boarddelete")
	public ModelAndView boardDelete(@RequestParam("bnumber") int bnumber) {
		mav = bs.boardDelete(bnumber);
		return mav;
	}
}
