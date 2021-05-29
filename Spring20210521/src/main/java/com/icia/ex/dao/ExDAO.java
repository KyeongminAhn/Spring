package com.icia.ex.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.ex.dto.ExDTO;

@Repository
public class ExDAO {
	// DAO: Data Access Object (DB에 접근해 데이터를 조회, 조작하는 객체)
	// DTO: Data Transfer Object (클래스 간 데이터 교환을 위한 매개체)
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public void insert(ExDTO dto) {
		sql.insert("ex.insertDB", dto);
	}

	public List<ExDTO> select() {
		return sql.selectList("ex.selectDB");
	}


}
