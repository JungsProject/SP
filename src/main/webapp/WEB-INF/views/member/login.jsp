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
	<jsp:include page="../inc/header.jsp"/>
	<h1>views/member/login.jsp</h1>
	
	<fieldset>
		<legend>로그인</legend>
		<form action="./login" class="fr" method="post">
		<div class="input-group">
			<input type="text" class="form-control" name="id" id="id" placeholder="ID">
		</div>
		<div class="input-group">
			<input type="password" class="form-control" name="pass" id="pass" placeholder="Password">
		</div>
		<div class="Btn">
			<button type="submit" class="log">로그인</button>
			<button type="button" class="btn" onclick="location.href='../member/join';">회원가입</button>
		</div>
		</form>
	</fieldset>
	
	
	
	<c:if test="${msg == false}">
		<div class="text-center">
			<p style="color: red;">로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요.</p>
		</div>
	</c:if>
	
	<!-- <script type="text/javascript">
			$(document).ready(function() {
			$(".log").on('click',function(){
				if ($("#id").val() == "") {
					alert("아이디를 입력해주세요.");
					$("#id").focus();
					return false;
				}
				if ($("#pass").val() == "") {
					alert("비밀번호를 입력해주세요.");
					$("#pass").focus();
					return false;
				}
				$('.fr').submit();
				});
			});
		</script> -->
</body>
</html>