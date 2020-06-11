<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>views/member/join.jsp</h1>
	
	<fieldset>
		<legend>회원가입</legend>
		<form action="./join" method="post">
		<div class="input-group">
			<div class="input-gorup-prepend">
					<span class="input-gorup-text">아이디</span>
			</div>
			<input type="text" class="form-control" name="id">
		</div>
		<div class="Btn">	
			<button type="button" class="btn">가입하기</button>
		</div>
		</form>
	
	</fieldset>
</body>
</html>