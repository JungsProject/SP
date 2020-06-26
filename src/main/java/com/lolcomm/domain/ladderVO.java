package com.lolcomm.domain;

public class ladderVO {
	private String summonerName;
	private String tier;
	private String LeaguePoints;
	private int wins;
	private int losses;
	private int winratio;
	public String getSummonerName() {
		return summonerName;
	}
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getLeaguePoints() {
		return LeaguePoints;
	}
	public void setLeaguePoints(String leaguePoints) {
		LeaguePoints = leaguePoints;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public int getWinratio() {
		return winratio;
	}
	public void setWinratio(int winratio) {
		this.winratio = winratio;
	}
	@Override
	public String toString() {
		return "ladderVO [summonerName=" + summonerName + ", tier=" + tier + ", LeaguePoints=" + LeaguePoints
				+ ", wins=" + wins + ", losses=" + losses + ", winratio=" + winratio + "]";
	}
	
	
}
