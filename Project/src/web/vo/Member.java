package web.vo;

import java.sql.Date;

public class Member {
	protected int mno;
	protected String id;
	protected String email;
	protected String pwd;
	protected String mname;
	protected Date creDate;
	
	
	public int getMno() {
		return mno;
	}
	public Member setMno(int mno) {
		this.mno = mno;
		return this;
	}
	public String getId() {
		return id;
	}
	public Member setId(String id) {
		this.id = id;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Member setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public Member setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	public String getMname() {
		return mname;
	}
	public Member setMname(String mname) {
		this.mname = mname;
		return this;
	}
	public Date getCreDate() {
		return creDate;
	}
	public Member setCreDate(Date creDate) {
		this.creDate = creDate;
		return this;
	}
	
	
	
	
}
