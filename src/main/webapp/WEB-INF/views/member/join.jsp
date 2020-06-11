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
		<div class="input-group">
			<div class="input-gorup-prepend">
					<span class="input-gorup-text">비밀번호</span>
			</div>
			<input type="password" class="form-control" name="pass">
		</div>
		<div class="input-group">
			<div class="input-gorup-prepend">
					<span class="input-gorup-text">이름</span>
			</div>
			<input type="text" class="form-control" name="name">
		</div>
		<div class="input-group">
			<div class="input-gorup-prepend">
					<span class="input-gorup-text">나이</span>
			</div>
			<input type="text" class="form-control" name="age">
		</div>
		<div class="input-group">
			<div class="input-gorup-prepend">
					<span class="input-gorup-text">닉네임</span>
			</div>
			<input type="text" class="form-control" name="nick">
		</div>
		<div class="input-group">
			<div class="input-gorup-prepend">
					<span class="input-gorup-text">이메일</span>
			</div>
			<input type="email" class="form-control" name="email">
		</div>
		<div class="input-group">
			<div class="input-gorup-prepend">
					<span class="input-gorup-text">연락처</span>
			</div>
			<input type="text" class="form-control" name="phone">
		</div>
		<div class="Btn">	
			<button type="submit" class="btn">가입하기</button>
		</div>
		
		</form>
	
	</fieldset>
</body>
</html>