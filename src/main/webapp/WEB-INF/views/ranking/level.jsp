<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소환사 레벨 랭킹 :: 롤 전적 검색 lolcomn.com  -전적 검색, 랭킹, 퀴즈</title>
</head>
<body>
<jsp:include page="../inc/header.jsp"/>
<div class="menu">
	<ol class="MenuList">
		<li class="Item"><a href="${pageContext.request.contextPath}/ranking/ladder">랭킹</a></li>
		<li class="Item"><a href="${pageContext.request.contextPath}/ranking/champions">챔피언</a></li>
		<li class="Item"><a href="${pageContext.request.contextPath}/ranking/level">레벨</a></li>
	</ol>
</div>
	
<div class="content">
	<table>
	<tr>
	<th></th>
	<th>소환사 명</th>
	<th>레벨</th>
	<th>티어</th>
	<th>랭크승률</th>
	</tr>
<c:forEach items="${rmList }" var="rmVO" varStatus="status">
	<tr>
	<th>${status.index+1}</th>
	<th>${rmVO.name }</th>
	<th>LV ${rmVO.summonerLevel }</th>
	<th>${rmVO.tier }(${rmVO.leaguePoints})</th>
	<th>${rmVO.wins}승 ${rmVO.losses}패 승률${rmVO.rating }</th>
	</tr>
</c:forEach>
	</table>
</div>
<jsp:include page="../inc/footer.jsp"/>
</body>
</html>