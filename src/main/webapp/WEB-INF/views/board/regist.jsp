<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<jsp:include page="../inc/header.jsp"/>

	<form method="POST">
	글제목 : <input type="text" name="title"> <br>
	작성자 : <input type="text" name="writer"> <br>
	내용 : <br>
	<textarea rows="15" cols="10" name="content"></textarea> <br>
	
	<input type="submit" value="글쓰기">
	
	</form>


	<jsp:include page="../inc/footer.jsp"/>
</body>
</html>