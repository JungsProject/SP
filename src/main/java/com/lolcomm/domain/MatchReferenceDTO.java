package com.lolcomm.domain;

public class MatchReferenceDTO {
	//소환사 검색 최근 경기
	private String platformId;
	private long gameId;
	private int champion;
	private int queue;
	private int season;
	private long timestamp;
	private String role;
	private String lane;
	
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public int getChampion() {
		return champion;
	}
	public void setChampion(int champion) {
		this.champion = champion;
	}
	public int getQueue() {
		return queue;
	}
	public void setQueue(int queue) {
		this.queue = queue;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	@Override
	public String toString() {
		return "MatchReferenceDTO [platformId=" + platformId + ", gameId=" + gameId + ", champion=" + champion
				+ ", queue=" + queue + ", season=" + season + ", timestamp=" + timestamp + ", role=" + role + ", lane="
				+ lane + "]";
	}

	
}
