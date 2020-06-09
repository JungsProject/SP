<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<script>
//ajax 예시
/* $.ajax({
    type : "POST",
    dataType: "json",
    data :{url: "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/귤린져"},//data에 주소 수정
    url : "http://localhost:8088/myapp/riotAPI",	//링크는 그대로 유지
    success : function(data) {
     alert(data);	//성공시 실행
    }
   }); */

</script>
</body>
</html>
