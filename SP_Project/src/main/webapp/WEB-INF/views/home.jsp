<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script src="<c:url value="/webjars/jquery/3.2.1/dist/jquery.js"/>"></script>


	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<button onclick="start();">버튼</button>
<script>
//ajax 예시
function start(){
 $.ajax({
    type : "POST",
    dataType: "json",
    data :{url: "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/귤린져"},//data에 주소 수정
    url : "<c:out value="${pageContext.request.contextPath}/riotAPI"></c:out>",	//링크는 그대로 유지
    success : function(data) {
    console.log(data);
    }
   }); 
}
</script>
</body>
</html>
