<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
            <li> <a href="#"> 롤퀴즈 </a> 
            	<ul>
            		<li>
						<a href="#">기본퀴즈</a>
					</li>
					<li>
						<a href="#">유저퀴즈</a>
					</li>
				</ul>
            </li> 
        </ul>

        <!-- 로그인, 마이페이지, 로그아웃 링크 -->
        <ul class="navbar_userlinks">
            	<c:if test="${null eq member}">
                <li> <a href="./member/login"> LOGIN </a> </li>
            	</c:if>
            	<c:if test="${member.permission eq 'ADMN'}">
                <li> <a href="#"> ADMIN_PAGE </a> </li>
                </c:if>
                <c:if test="${null ne member}">
                <li> <a href="#"> MYPAGE </a> </li>
                <li> <a href="#"> LOGOUT </a> </li>
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