package com.lolcomm.domain;

public class RiotMemberMasteryVO {

	int championId;		//챔피언 아이디
	int championLevel;	//챔피언 레벨
	int championPoints;	//챔피언 마스터리 포인트
	int lastPlayTime;	//마지막 플레이 시간
	int championPointsSinceLastLevel;	//챔피언 레벨 까지 찍고 남은 포인트
	int championPointsUntilNextLevel;	//다음레벨까지 남은 포인트
	boolean chestGranted;	//챔피언 상자 부여 여부
	int tokensEarned;		//획득한 마스터레벨 토큰수 
	String summonerId;		//사용자 서모너 아이디
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}
	public int getChampionLevel() {
		return championLevel;
	}
	public void setChampionLevel(int championLevel) {
		this.championLevel = championLevel;
	}
	public int getChampionPoints() {
		return championPoints;
	}
	public void setChampionPoints(int championPoints) {
		this.championPoints = championPoints;
	}
	public int getLastPlayTime() {
		return lastPlayTime;
	}
	public void setLastPlayTime(int lastPlayTime) {
		this.lastPlayTime = lastPlayTime;
	}
	public int getChampionPointsSinceLastLevel() {
		return championPointsSinceLastLevel;
	}
	public void setChampionPointsSinceLastLevel(int championPointsSinceLastLevel) {
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
	}
	public int getChampionPointsUntilNextLevel() {
		return championPointsUntilNextLevel;
	}
	public void setChampionPointsUntilNextLevel(int championPointsUntilNextLevel) {
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
	}
	public boolean isChestGranted() {
		return chestGranted;
	}
	public void setChestGranted(boolean chestGranted) {
		this.chestGranted = chestGranted;
	}
	public int getTokensEarned() {
		return tokensEarned;
	}
	public void setTokensEarned(int tokensEarned) {
		this.tokensEarned = tokensEarned;
	}
	public String getSummonerId() {
		return summonerId;
	}
	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	@Override
	public String toString() {
		return "RiotMemberMastery [championId=" + championId + ", championLevel=" + championLevel + ", championPoints="
				+ championPoints + ", lastPlayTime=" + lastPlayTime + ", championPointsSinceLastLevel="
				+ championPointsSinceLastLevel + ", championPointsUntilNextLevel=" + championPointsUntilNextLevel
				+ ", chestGranted=" + chestGranted + ", tokensEarned=" + tokensEarned + ", summonerId=" + summonerId
				+ "]";
	}

	
}
