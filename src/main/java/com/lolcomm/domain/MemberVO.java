package com.lolcomm.domain;

import java.util.Date;

public class MemberVO {
	
	private String id;
	private String pass;
	private String name;
	private String nick;
	private String email;
	private String phone;
	private Date reg_date;
	private Date modify_date;
	private String delete_yn;
	private String ban_yn;
	private String permission;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	public String getBan_yn() {
		return ban_yn;
	}
	public void setBan_yn(String ban_yn) {
		this.ban_yn = ban_yn;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", nick=" + nick + ", email=" + email
				+ ", phone=" + phone + ", reg_date=" + reg_date + ", modify_date=" + modify_date + ", delete_yn="
				+ delete_yn + ", ban_yn=" + ban_yn + ", permission=" + permission + "]";
	}
	
	
}