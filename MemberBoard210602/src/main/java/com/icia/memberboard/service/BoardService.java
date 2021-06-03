package com.icia.memberboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.memberboard.dao.BoardDAO;
import com.icia.memberboard.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO bdao;
	
	private ModelAndView mav;
	
	// 글목록
	public ModelAndView boardList() {
		mav = new ModelAndView();
		List<BoardDTO> boardList = bdao.boardList();
		
		mav.addObject("boardList", boardList);
		mav.setViewName("boardlist");
		
		return mav;
	}
	// 글쓰기
	public ModelAndView boardWrite(BoardDTO board) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile bfile = board.getBfile();
		String bfilename = bfile.getOriginalFilename();
		bfilename = System.currentTimeMillis() + "-" + bfilename;
		String savePath = "C:\\Users\\Kyeongmin Ahn\\Desktop\\kmAhn\\kotlin\\source_ahn\\spring\\Spring\\Board210527\\src\\main\\webapp\\resources\\upload\\"+bfilename;
		if(!bfile.isEmpty()) {
			bfile.transferTo(new File(savePath));
		}
		board.setBfilename(bfilename);
		bdao.boardWrite(board);
		mav.setViewName("redirect:/boardlist");
		return mav;
	}
	// 글 조회
	public ModelAndView boardView(int bnumber) {
		mav = new ModelAndView();
		bdao.boardHits(bnumber);

		BoardDTO board = bdao.boardView(bnumber);
		
		mav.addObject("board",board);
		mav.setViewName("boardview");
		return mav;
	}
	public ModelAndView boardUpdate(int bnumber) {
		mav = new ModelAndView();
		BoardDTO board = bdao.boardView(bnumber);
		mav.addObject("boardUpdate", board);
		mav.setViewName("boardupdate");
		return mav;
	}
	public ModelAndView updateProcess(BoardDTO board) {
		mav = new ModelAndView();
		int updateResult = bdao.updateProcess(board);
		if(updateResult > 0) {
			// 해당글의 상세화면 출력
			mav.setViewName("redirect:/boardview?bnumber="+board.getBnumber()); 
		}
		return mav;
	}
	public ModelAndView boardDelete(int bnumber) {
		mav = new ModelAndView();
		int deleteResult = bdao.boardDelete(bnumber);
		if(deleteResult > 0) {
			mav.setViewName("redirect:/boardlist");
		}
		return mav;
	}
	
	
	
	
	
	
	
	
}
