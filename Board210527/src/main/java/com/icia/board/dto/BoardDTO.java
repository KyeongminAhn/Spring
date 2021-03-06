package com.icia.board.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

@Data // getter, setter, toString, 생성자를 자동으로 만들어줌.
//@Getter
//@Setter
//@ToString
public class BoardDTO {
	private int bnumber;
	private String btitle;
	private String bpassword;
	private String bwriter;
	private String bcontents;
	private String bdate;
	private int bhits;
	
	// 파일을 담기 위한 필드(boardwrite.jsp에서 Controller로 전달할 때)
	//(bfile 추가로 인한, file이 실제로 DB에 저장하는 건 아니다. filename만!)
	private MultipartFile bfile;
	// 파일명을 담기 위한 필드
	private String bfilename;
}
	
	//	public String getBtitle() {
//		return btitle;
//	}
//	public void setBtitle(String btitle) {
//		this.btitle = btitle;
//	}
//	public String getBpassword() {
//		return bpassword;
//	}
//	public void setBpassword(String bpassword) {
//		this.bpassword = bpassword;
//	}
//	public String getBwriter() {
//		return bwriter;
//	}
//	public void setBwriter(String bwriter) {
//		this.bwriter = bwriter;
//	}
//	public String getBcontents() {
//		return bcontents;
//	}
//	public void setBcontents(String bcontents) {
//		this.bcontents = bcontents;
//	}
//	
//	@Override
//	public String toString() {
//		return "BoardDTO [btitle=" + btitle + ", bpassword=" + bpassword + ", bwriter=" + bwriter + ", bcontents="
//				+ bcontents + "]";
//	}
//	
//}