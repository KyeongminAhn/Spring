package com.icia.board.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView boardWrite(@ModelAttribute BoardDTO board) {
		mav = bs.boardWrite(board);
		// 글쓰기 발행(성공) 시, 글목록 출력되도록 
		return mav;
	}
	
	// 파일첨부 글쓰기
	@RequestMapping(value="/boardwritefile")
	public ModelAndView boardWriteFile(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		mav = bs.boardWriteFile(board);
		return mav;
	}
	
	// 글목록
	@RequestMapping(value="/boardlist")
	public ModelAndView boardList() {
		mav = bs.boardList();
		return mav;
	}
	
	// 글조회 (+페이징목록으로 돌아가기)
	@RequestMapping(value="/boardview")
	public ModelAndView boardView(@RequestParam("bnumber") int bnumber,
			@RequestParam(value="page", required=false, defaultValue="1") int page) {
		mav = bs.boardView(bnumber, page);
		return mav;
	}
	
	//글수정화면 요청 메소드
	@RequestMapping(value="/boardupdate")
	public ModelAndView boardUpdate(@RequestParam("bnumber") int bnumber) {
		mav = bs.boardUpdate(bnumber);
		return mav;
	}
	
	// 글수정 처리 메소드 
	@RequestMapping(value="/updateprocess")
	public ModelAndView updateProcess(@ModelAttribute BoardDTO board) {
		mav = bs.updateProcess(board);
		return mav;
	}
	
	// 글삭제 처리 메소드
	@RequestMapping(value="/boarddelete")
	public ModelAndView boardDelete(@RequestParam("bnumber") int bnumber) {
		mav = bs.boardDelete(bnumber);
		return mav;
	}
	
	// 페이징 처리
	@RequestMapping(value="/paging")
	public ModelAndView boardPaging(@RequestParam(value="page", required=false, defaultValue="1") int page) {
	//												혹여나 page파라미터 전달받지 못하더라도 기본으로 보여줘야하는 페이지=첫 페이지(기본값)
		mav =bs.boardPaging(page);
		return mav;
	}
	
	
}
