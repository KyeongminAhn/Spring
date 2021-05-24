package com.icia.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sql;

	public void insert(MemberDTO dto) {
		sql.insert("member.insertDB", dto);
	}

	public List<MemberDTO> select() {
		return sql.selectList("member.selectDB");
	}

	public MemberDTO memberView(String mId) {
		return sql.selectOne("member.memberview", mId);
	}

}
