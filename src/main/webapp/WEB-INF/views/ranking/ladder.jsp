<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<div class="content">
	<table>
	<tr>
	<th></th>
	<th>소환사 명</th>
	<th>티어</th>
	<th>LP</th>
	<th>랭크승률</th>
	</tr>

<c:forEach items="${rankList}" var="rmVO" varStatus="status">
	<tr>
	<th>${status.count+(page-1)*100}</th>
	<th>${rmVO.summonerName}</th>
	<th>${rmVO.tier}</th>
	<th>${rmVO.leaguePoints}</th>
	<th>${rmVO.wins}승 ${rmVO.losses}패 승률${rmVO.winratio}%</th>
	</tr>
</c:forEach>
	</table>
</div>
<div class="paging">
	<c:if test="${pagingVO.startPage !=1 }">
		<a href="./${pagingVO.startPage - 1 }"><</a>
	</c:if>
	<c:forEach begin="${pagingVO.startPage }" end="${pagingVO.endPage }" var="p">
			<c:choose>
				<c:when test="${p == pagingVO.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != pagingVO.nowPage }">
					<a href="./${p }">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
	<c:if test="${pagingVO.endPage != pagingVO.lastPage}">
		<a href="./${pagingVO.endPage + 1 }">></a>
	</c:if>
</div>
<jsp:include page="../inc/footer.jsp"/>
</body>
</html>