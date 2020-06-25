<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${UserName} - 게임 전적 - League Of Legend</title>
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>

<script>


$(document).ready(function(){
	document.getElementById("SummonerInfo").style.display="none";
	
})

// document.getElementByid("SummonerInfo").style.display="block";


// $(#SummonerInfo).hide();
// 	$(#SummonerInfo).show();
function onInfo(){

	var con = document.getElementById("SummonerInfo");
	
	if(con.style.display=='none'){
		con.style.display="block";
	}else{
		con.style.display="none";
	}
}

</script>
</head>
<body>

	검색아이디 : ${UserName} <br>
	
	<input type="button" value="Summoner정보" onclick="onInfo();" />
	
	<div id="SummonerInfo">
	<h4>Summoner id정보 : ${Summoner.id}</h4>
	<h4>Summoner accountId정보 : ${Summoner.accountId}</h4>
	<h4>Summoner puuid정보 : ${Summoner.puuid}</h4>
	<h4>Summoner name정보 : ${Summoner.name}</h4>
	<h4>Summoner profileIconId정보 : ${Summoner.profileIconId}</h4>
	<h4>Summoner revisionDate정보 : ${Summoner.revisionDate}</h4>
	<h4>Summoner summonerLevel정보 : ${Summoner.summonerLevel}</h4>
	</div>


	<h4>jsonString4 정보 : ${jsonString4}</h4>
	
	<h4>경기 정보 :</h4>
	
	<p>${matchesList.get(0).getRole()}<p>
	<p>${matchesList.get(0).getLane()}<p>
	<p>${matchesList.get(0).getGameId()}<p>
	
	<h4>--------------</h4>
	
	<p>${matchesList.get(1).getRole()}<p>
	<p>${matchesList.get(1).getLane()}<p>
	<p>${matchesList.get(1).getGameId()}<p>

	<hr>
	<h4>솔로랭크 정보 : ${SoloRank}</h4>
	<h4>팀랭크 정보 : ${TeamRank}</h4>
	
	<h4>LeagueList 정보 : ${LeagueList}</h4>
	
	<hr>
	
	<h4>RedTeam 정보 : ${RedTeam}</h4>
	<h4>BlueTeam 정보 : ${BlueTeam}</h4>




	
</body>
</html>