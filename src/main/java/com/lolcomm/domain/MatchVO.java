package com.lolcomm.domain;

import java.util.List;

public class MatchVO {
	
	private long gameId;
	private String platfromId;
	private long gameCreation;
	private long gameDuration;
	private int queueId;
	private int mapId;
	private int seasonId;
	private String gameVersion;
	private String gameMode;
	private String gameType;
	private List<TeamStatsDTO> teams;
	
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public String getPlatfromId() {
		return platfromId;
	}
	public void setPlatfromId(String platfromId) {
		this.platfromId = platfromId;
	}
	public long getGameCreation() {
		return gameCreation;
	}
	public void setGameCreation(long gameCreation) {
		this.gameCreation = gameCreation;
	}
	public long getGameDuration() {
		return gameDuration;
	}
	public void setGameDuration(long gameDuration) {
		this.gameDuration = gameDuration;
	}
	public int getQueueId() {
		return queueId;
	}
	public void setQueueId(int queueId) {
		this.queueId = queueId;
	}
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public int getSeasonId() {
		return seasonId;
	}
	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}
	public String getGameVersion() {
		return gameVersion;
	}
	public void setGameVersion(String gameVersion) {
		this.gameVersion = gameVersion;
	}
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public List<TeamStatsDTO> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamStatsDTO> teams) {
		this.teams = teams;
	}
	@Override
	public String toString() {
		return "MatchVO [gameId=" + gameId + ", platfromId=" + platfromId + ", gameCreation=" + gameCreation
				+ ", gameDuration=" + gameDuration + ", queueId=" + queueId + ", mapId=" + mapId + ", seasonId="
				+ seasonId + ", gameVersion=" + gameVersion + ", gameMode=" + gameMode + ", gameType=" + gameType
				+ ", teams=" + teams + "]";
	}
	
	

}
