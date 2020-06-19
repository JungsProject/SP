package com.lolcomm.domain;

import java.sql.Date;

public class UserQuizVO {
	
	private Integer num;
	private String id;
	private String nick;
	private String type;
	private String category;
	private int difficulty;
	private String quiz;
	private String quiz_exam;
	private String quiz_ans;
	private String ori_file;
	private String save_file;
	private Date reg_date;
	private Date modify_date;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public String getQuiz() {
		return quiz;
	}
	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}
	public String getQuiz_exam() {
		return quiz_exam;
	}
	public void setQuiz_exam(String quiz_exam) {
		this.quiz_exam = quiz_exam;
	}
	public String getQuiz_ans() {
		return quiz_ans;
	}
	public void setQuiz_ans(String quiz_ans) {
		this.quiz_ans = quiz_ans;
	}
	public String getOri_file() {
		return ori_file;
	}
	public void setOri_file(String ori_file) {
		this.ori_file = ori_file;
	}
	public String getSave_file() {
		return save_file;
	}
	public void setSave_file(String save_file) {
		this.save_file = save_file;
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
	
	@Override
	public String toString() {
		return "UserQuizVO [num=" + num + ", id=" + id + ", nick=" + nick + ", type=" + type + ", category=" + category
				+ ", difficulty=" + difficulty + ", quiz=" + quiz + ", quiz_exam=" + quiz_exam + ", quiz_ans="
				+ quiz_ans + ", ori_file=" + ori_file + ", save_file=" + save_file + ", reg_date=" + reg_date
				+ ", modify_date=" + modify_date + "]";
	}
	
}
