package com.lolcomm.domain;

public class UserDataVO {
	
	private int num;
	private String UserName;
	private String accountId;
	private String summonerId;
	private long gameId;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	
	@Override
	public String toString() {
		return "UserDataVO [num=" + num + ", UserName=" + UserName + ", accountId=" + accountId + ", summonerId="
				+ summonerId + ", gameId=" + gameId + "]";
	}
	
	
	

}
