package com.icia.member.dto;

public class MemberDTO {

	private String mid;
	private String mPassword;
	private String mName;
	private String mEmail;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", mPassword=" + mPassword + ", mName=" + mName + ", mEmail=" + mEmail + "]";
	}
}
