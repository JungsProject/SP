<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <li> <a href="#"> 소환사 검색(API팀) </a> </li> 
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
            <%
                //로그인 되었는지
                String user = (String) session.getAttribute("id");
                if(user == null){
            %>
                <li> <a href="#"> LOGIN </a> </li>
            <%
                }else if(user.equals("admin")){ 
            %>
                <li> <a href="#"> ADMIN_PAGE </a> </li>
                <li> <a href="#"> MYPAGE </a> </li>
                <li> <a href="#"> LOGOUT </a> </li>
            <% 
                }else{ 
            %>
                <li> <a href="#"> MYPAGE </a> </li>
                <li> <a href="#"> LOGOUT </a> </li>
            <% 
                } 
            %> 
        </ul>

        <!-- <a href="#" class="navbar_toggleBtn">
            <i class="fas fa-bars"></i>
        </a> -->

    </nav>





</body>
</html>