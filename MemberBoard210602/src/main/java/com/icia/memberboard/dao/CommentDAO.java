package com.icia.memberboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public List<CommentDAO> commentList(int cbnumber) {
		return sql.selectList("cm.commentlist", cbnumber);
	}

}
