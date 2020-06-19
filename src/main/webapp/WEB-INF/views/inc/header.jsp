<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar">

        <!-- 로고 -->
        <div class="navbar_logo">
            <a href="#"> LOL Comm. </a>
        </div>

        <!-- 메인메뉴  -->
        <ul class="navbar_menu">
            <li> <input type="text" name="search_name" id="search_name"> <input type="button" value="검색" onclick="search();"></li> 
             <c:if test="${null eq member}">
            <li> <a href="${pageContext.request.contextPath}/ranking/ladder"> 롤 랭킹 </a> 
            <li> <a href="#"> 롤퀴즈 </a> 
            	<ul>
            		<li>
						<a href="#">기본퀴즈</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/userquiz/regist">유저퀴즈</a>
					</li>
				</ul>
            </li>
            <!-- 게시판 -->
            <li> <a href="#"> 게시판 </a> 
            	<ul>
            		<li>
						<a href="${pageContext.request.contextPath}/board/regist">글작성</a>
					</li>
					<li>
						<a href="#">게시판리스트</a>
					</li>
				</ul>
            </li> 
          </c:if>
		
		  <c:if test="${member.permission eq 'ADMN'}">
		  <li> <a href="${pageContext.request.contextPath}/admin/admin_delete"> 불량회원 강제 벤 </a> 
            <li> <a href="${pageContext.request.contextPath}/admin/member_info"> 회원 정보 검색 </a> 
            <li> <a href="#"> 전체 퀴즈 관리 </a> 
            	<ul>
            		<li>
						<a href="#">기본퀴즈 관리</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/userquiz/regist">유저퀴즈 관리</a>
					</li>
				</ul>
            </li>
            <!-- 게시판 -->
            <li> <a href="#"> 게시판관리 </a> 
            	<ul>
            		<li>
						<a href="${pageContext.request.contextPath}/board/regist">글작성</a>
					</li>
					<li>
						<a href="#">게시판리스트</a>
					</li>
		  </c:if>
        </ul>

        <!-- 로그인, 마이페이지, 로그아웃 링크 -->
        <ul class="navbar_userlinks">
            	<c:if test="${null eq member}">
                <li> <a href="${pageContext.request.contextPath}/member/login"> LOGIN </a> </li>
            	</c:if>
                <c:if test="${null ne member}">
                <small>${member.nick } 님 환영합니다.</small>
                <c:if test="${member.permission eq 'USR'}">
                <li> <a href="#"> MYPAGE </a> </li>
                </c:if>
                <c:if test="${member.permission eq 'ADMN'}">
                <li> <a href="${pageContext.request.contextPath}/admin/adminPage"> ADMIN_PAGE </a> </li>
                </c:if>
                <li> <a href="${pageContext.request.contextPath}/member/logout"> LOGOUT </a> </li>
                </c:if>
        </ul> 

        <!-- <a href="#" class="navbar_toggleBtn">
            <i class="fas fa-bars"></i>
        </a> -->

    </nav>

<script>

	function search(){
		var data=document.getElementById("search_name").value;
		location.href="${pageContext.request.contextPath}/summoner/"+data;
		}
	
</script>



</body>
</html>