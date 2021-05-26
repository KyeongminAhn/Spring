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

	public int insertDB(MemberDTO dto) {
		// mapper의 namespace=member, 
		return sql.insert("member.insertDB", dto);
	}

	public List<MemberDTO> selectDB() {
		return sql.selectList("member.selectDB");
	}

	public MemberDTO memberView(String mId) {
		return sql.selectOne("member.memberview", mId);
	}

	public String memberLogin(MemberDTO dto) {
		return sql.selectOne("member.memberLogin", dto);
	}
	
	public MemberDTO update(String loginId) {
		return sql.selectOne("member.memberupdate", loginId);
	}

	public int updateProcess(MemberDTO dto) {
		return sql.update("member.updateprocess", dto);
	}

	public void memberDelete(String mId) {
		sql.delete("member.memberdelete", mId);	
	}

	public String idCheck(String mId) {
		return sql.selectOne("member.idcheck", mId);
	}

}
