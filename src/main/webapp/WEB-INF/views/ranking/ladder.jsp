<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소환사 래더 랭킹 :: 롤 전적 검색 lolcomn.com  -전적 검색, 랭킹, 퀴즈</title>
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
<jsp:include page="../inc/footer.jsp"/>
</body>
</html>