package com.lolcomm.domain;

public class levelRankingVO {
	String name;
	int summonerLevel;
	String tier;
	int leaguePoints;
	int wins;
	int losses;
	int rating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSummonerLevel() {
		return summonerLevel;
	}
	public void setSummonerLevel(int summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public int getLeaguePoints() {
		return leaguePoints;
	}
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "levelRankingVO [name=" + name + ", summonerLevel=" + summonerLevel + ", tier=" + tier
				+ ", leaguePoints=" + leaguePoints + ", wins=" + wins + ", losses=" + losses + ", rating=" + rating
				+ "]";
	}
	
	
}
