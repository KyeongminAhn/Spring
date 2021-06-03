package com.icia.memberboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.memberboard.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<BoardDTO> boardList() {
		return sql.selectList("bm.boardlist");
	}

	public void boardWrite(BoardDTO board) {
		sql.insert("bm.boardwrite", board);
	}

	public BoardDTO boardView(int bnumber) {
		return sql.selectOne("bm.boardview", bnumber);
	}

	public void boardHits(int bnumber) {
		sql.update("bm.boardhits", bnumber);
	}

	public int updateProcess(BoardDTO board) {
		return sql.update("bm.boardupdate", board);
	}

	public int boardDelete(int bnumber) {
		return sql.delete("bm.boarddelete", bnumber);
	}
}
