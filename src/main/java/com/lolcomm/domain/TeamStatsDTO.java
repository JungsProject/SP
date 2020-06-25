package com.lolcomm.domain;

import java.util.List;

public class TeamStatsDTO {
	
	private int teamId;
	private String win;
	private boolean firstBlood;
	private boolean firstTower;
	private boolean firstInhibitor;
	private boolean firstBaron;
	private boolean firstDragon;
	private boolean fristRiftHearaId;
	private int towerKills;
	private int inhibitorKills;
	private int baronKills;
	private int dragonKills;
	private int vilemawKills;
	private int riftHeraIdKills;
	private int dominionVictoryScore;
	private List<TeamBansDTO> bans;
	
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public boolean isFirstBlood() {
		return firstBlood;
	}

	public void setFirstBlood(boolean firstBlood) {
		this.firstBlood = firstBlood;
	}

	public boolean isFirstTower() {
		return firstTower;
	}

	public void setFirstTower(boolean firstTower) {
		this.firstTower = firstTower;
	}

	public boolean isFirstInhibitor() {
		return firstInhibitor;
	}

	public void setFirstInhibitor(boolean firstInhibitor) {
		this.firstInhibitor = firstInhibitor;
	}

	public boolean isFirstBaron() {
		return firstBaron;
	}

	public void setFirstBaron(boolean firstBaron) {
		this.firstBaron = firstBaron;
	}

	public boolean isFirstDragon() {
		return firstDragon;
	}

	public void setFirstDragon(boolean firstDragon) {
		this.firstDragon = firstDragon;
	}

	public boolean isFristRiftHearaId() {
		return fristRiftHearaId;
	}

	public void setFristRiftHearaId(boolean fristRiftHearaId) {
		this.fristRiftHearaId = fristRiftHearaId;
	}

	public int getTowerKills() {
		return towerKills;
	}

	public void setTowerKills(int towerKills) {
		this.towerKills = towerKills;
	}

	public int getInhibitorKills() {
		return inhibitorKills;
	}

	public void setInhibitorKills(int inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public int getBaronKills() {
		return baronKills;
	}

	public void setBaronKills(int baronKills) {
		this.baronKills = baronKills;
	}

	public int getDragonKills() {
		return dragonKills;
	}

	public void setDragonKills(int dragonKills) {
		this.dragonKills = dragonKills;
	}

	public int getVilemawKills() {
		return vilemawKills;
	}

	public void setVilemawKills(int vilemawKills) {
		this.vilemawKills = vilemawKills;
	}

	public int getRiftHeraIdKills() {
		return riftHeraIdKills;
	}

	public void setRiftHeraIdKills(int riftHeraIdKills) {
		this.riftHeraIdKills = riftHeraIdKills;
	}

	public int getDominionVictoryScore() {
		return dominionVictoryScore;
	}

	public void setDominionVictoryScore(int dominionVictoryScore) {
		this.dominionVictoryScore = dominionVictoryScore;
	}

	public List<TeamBansDTO> getBans() {
		return bans;
	}

	public void setBans(List<TeamBansDTO> bans) {
		this.bans = bans;
	}


	@Override
	public String toString() {
		return "TeamStatsDTO [teamId=" + teamId + ", win=" + win + ", firstBlood=" + firstBlood + ", firstTower="
				+ firstTower + ", firstInhibitor=" + firstInhibitor + ", firstBaron=" + firstBaron + ", firstDragon="
				+ firstDragon + ", fristRiftHearaId=" + fristRiftHearaId + ", towerKills=" + towerKills
				+ ", inhibitorKills=" + inhibitorKills + ", baronKills=" + baronKills + ", dragonKills=" + dragonKills
				+ ", vilemawKills=" + vilemawKills + ", riftHeraIdKills=" + riftHeraIdKills + ", dominionVictoryScore="
				+ dominionVictoryScore + ", bans=" + bans + "]";
	}
	

	
	
	

}
