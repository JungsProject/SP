package com.lolcomm.domain;

public class TeamBansDTO {

	private int championId;
	private int pickTurn;
	
	public int getChampionId() {
		return championId;
	}



	public void setChampionId(int championId) {
		this.championId = championId;
	}



	public int getPickTurn() {
		return pickTurn;
	}



	public void setPickTurn(int pickTurn) {
		this.pickTurn = pickTurn;
	}



	@Override
	public String toString() {
		return "TeamBansDTO [championId=" + championId + ", pickTurn=" + pickTurn + "]";
	}
	
	
}
