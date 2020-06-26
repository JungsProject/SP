package com.lolcomm.domain;

import java.util.List;

public class RiotRankVO {

	private String tier;
	private String leagueId;
	private String queue;
	private String name;
	private List<RiotMemberLeagueVO> entries;
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<RiotMemberLeagueVO> getEntries() {
		return entries;
	}
	public void setEntries(List<RiotMemberLeagueVO> entries) {
		this.entries = entries;
	}
	@Override
	public String toString() {
		return "RiotRankVO [tier=" + tier + ", leagueId=" + leagueId + ", queue=" + queue + ", name=" + name
				+ ", entries=" + entries + "]";
	}
	
	
}
