package com.lolcomm.domain;

import java.util.List;

public class matchListVO {

	private List<MatchReferenceDTO> matches;
	private int startIndex;
	private int endIndex;
	private int totalGames;
	
	public List<MatchReferenceDTO> getMatches() {
		return matches;
	}
	public void setMatches(List<MatchReferenceDTO> matches) {
		this.matches = matches;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public int getTotalGames() {
		return totalGames;
	}
	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}
	
	@Override
	public String toString() {
		return "matchListVO [matches=" + matches + ", startIndex=" + startIndex + ", endIndex=" + endIndex
				+ ", totalGames=" + totalGames + "]";
	}
	

}
