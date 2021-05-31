package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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
	
	public ModelAndView boardWrite(BoardDTO board) {
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
	
	// 글 수정 요청 받고
	public ModelAndView boardUpdate(int bnumber) {
		// 이 메소드의 목적: DB에서 bumber에 해당하는 데이터를 가져와서
		// boardupdate.jsp로 목적지를 지정.
		mav = new ModelAndView();
		BoardDTO board = bdao.boardView(bnumber);
		mav.addObject("boardUpdate", board);
		mav.setViewName("boardupdate");
		return mav;
	}
	
	// 글 수정 처리
	public ModelAndView updateProcess(BoardDTO board) {
		mav = new ModelAndView();
		int updateResult = bdao.updateProcess(board);
		if(updateResult > 0) {
//			mav.setViewName("redirect:/boardlist"); // 목록출력(boardlist.jsp)
			mav.setViewName("redirect:/boardview?bnumber="+board.getBnumber()); // 해당글의 상세화면 출력
		}
		return mav;
	}
	// 어떤 방식으로 할 지는 선택! 정해진 답은 없다.
	
	// 글 삭제 처리
	public ModelAndView boardDelete(int bnumber) {
		mav = new ModelAndView();
		int deleteResult = bdao.boardDelete(bnumber);
		if(deleteResult > 0) {
			mav.setViewName("redirect:/boardlist");
		}
		return mav;
	}
	
	// 파일 추가 처리
	public ModelAndView boardWriteFile(BoardDTO board) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		// dto에 담긴 파일을 가져옴.
		MultipartFile bfile = board.getBfile();
		// (DB에 저장할)파일 이름을 가져옴.
		String bfilename = bfile.getOriginalFilename();
		// 파일명 중복을 피하기 위해 파일이름 앞에 현재 시간값을 붙인다.
		bfilename = System.currentTimeMillis() + "-" + bfilename;
		System.out.println("boardWriteFile 메소드" + bfilename);
		// 파일 저장하기
		String savePath = "C:\\Users\\Kyeongmin Ahn\\Desktop\\kmAhn\\kotlin\\source_ahn\\spring\\Spring\\Board210527\\src\\main\\webapp\\resources\\upload\\"+bfilename;
		// bfile이 비어있지 않다면(즉 파일이 있으면) savePath에 저장을 하겠다.
		if(!bfile.isEmpty()) {
			bfile.transferTo(new File(savePath));
		}
		// 여기까지의 내용은 파일을 저장하는 과정
		
		board.setBfilename(bfilename);
		bdao.boardWriteFile(board);
		
		mav.setViewName("redirect:/boardlist");
		
		return mav;
	}
	
}
