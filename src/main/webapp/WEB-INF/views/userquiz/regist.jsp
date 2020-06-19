<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저퀴즈 등록</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/userquiz/css/register.css" />" rel="stylesheet">

<!-- 로그인 확인 -->
<c:if test="${member eq null}">
	<script type="text/javascript">
		alert("로그인이 필요합니다.");
		location.href="/member/login";
	</script>
</c:if>

</head>
<body>

	<jsp:include page="../inc/header.jsp"/>
	
	<div class="container" style="text-align: center; max-width: 900px; margin-top: 4%;">
	<fieldset>
		<legend>유저퀴즈 등록</legend>
		<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${member.id }">
		<div class="input-group">
			<div class="input-group-prepend">
					<span class="input-group-text">닉네임</span>
			</div>
			<input type="text" class="form-control" name="nick" value="${member.nick}" readonly="readonly">
		</div>
		<hr>
		<div class="input-group">
			<div class="input-group-prepend" style="margin-right: 10px;">
					<span class="input-group-text">문제유형</span>
			</div>
			<div class="form-check-inline">
			<label class="form-check-label">
				<input type="radio" class="form-check-input 1" name="type" value="주관식" checked="checked">주관식
			</label>
		</div>
		<div class="form-check-inline">
			<label class="form-check-label">
				<input type="radio" class="form-check-input 2" name="type" value="객관식">객관식
			</label>
		</div>
		<div class="form-check-inline">
			<label class="form-check-label">
				<input type="radio" class="form-check-input 3" name="type" value="주관식+파일">주관식+파일(이미지,동영상,오디오 등)
			</label>
		</div>
		<div class="form-check-inline">
			<label class="form-check-label">
				<input type="radio" class="form-check-input 4" name="type" value="객관식+파일">객관식+파일(이미지,동영상,오디오 등)
			</label>
		</div>
			<!-- 	<input type="radio" name="type" class="form-control 1" value="주관식" checked="checked">주관식<br>
				<input type="radio" name="type" class="form-control 2" value="객관식">객관식<br>
				<input type="radio" name="type" class="form-control 3" value="주관식+파일">주관식+파일(이미지,동영상,오디오 등)
				<input type="radio" name="type" class="form-control 4" value="객관식+파일">객관식+파일(이미지,동영상,오디오 등) -->
		</div>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">카테고리</span>
			</div>
			<select class="form-control" name="category">
				<option value="대회">대회</option>
				<option value="세계관">세계관</option>
				<option value="스킨">스킨</option>
				<option value="포지션">포지션</option>
				<option value="스킬">스킬</option>
				<option value="기본정보">기본정보</option>
			</select>
		</div>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">난이도</span>
			</div>
			<select class="form-control" name="difficulty">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>
		</div>
		<div class="quiz">
			<div class="quiz1">
				<div class="input-group">
					<div class="input-group-prepend">
							<span class="input-group-text">문제</span>
					</div>
					<input type="text" class="form-control" name="quiz">
				</div>
				<div class="input-group">
					<div class="input-group-prepend">
							<span class="input-group-text">정답</span>
					</div>
					<input type="text" class="form-control quiz-ans" name="quiz_ans">
				</div>
			</div>
		</div>
		<script>
	$('.1').click(function() {
		$('.quiz1').remove();
		$('.quiz2').remove();
		$('.quiz3').remove();
		$('.quiz4').remove();
		$('.quiz').append(
				'<div class="quiz3"> <div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">문제</span> </div> <input type="text" class="form-control" name="quiz"> </div>'
				+ '<div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">정답</span> </div> <input type="text" class="form-control quiz-ans" name="quiz_ans"> </div> </div>'
			);
	});
	$('.2').click(function() {
		var maxNum = 4;
		var examNum = 0;
		$('.quiz1').remove();
		$('.quiz2').remove();
		$('.quiz3').remove();
		$('.quiz4').remove();
		$('.quiz').append(
			'<div class="quiz2"> <div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">문제</span> </div> <input type="text" class="form-control" name="quiz"> </div>'
			+ '<div class="exam"> <small>보기</small><br> </div> <input type="button" class="btn btn-outline-primary btn-sm examAdd" value="보기 추가">'
			+ '<div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">정답</span> </div> <input type="text" class="form-control" class="quiz-ans" name="quiz_ans" placeholder="보기 중 정답번호만 입력해주세요."> </div> </div>'
		);
		$('.examAdd').click(function() {
			if(examNum < maxNum) {
			++examNum;
			var prevNum = examNum-1;
			$('.examRemove'+prevNum).hide();
			$('.exam').append(
					'<div class="ex'+examNum+'"><div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">'+examNum+' </span> </div> <input type="text" class="form-control exam'+examNum+'" name="quiz_exam"> <input type="button" class="btn btn-danger btn-sm examRemove'+examNum+'" value="삭제" ></div> </div>'
			);
			$('.examRemove'+examNum).click(function() {
				$('.ex'+examNum).remove();
				--examNum;
				$('.examRemove'+examNum).show();
			});
			} else {
				alert("보기는 최대 4개 까지 등록 가능합니다.");
			}
		});
	});
	$('.3').click(function() {
		$('.quiz1').remove();
		$('.quiz2').remove();
		$('.quiz3').remove();
		$('.quiz4').remove();
		$('.quiz').append(
			'<div class="quiz3"> <div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">문제</span> </div> <input type="text" class="form-control" name="quiz"> </div>'
			+ '<div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">파일첨부</span> </div> <input type="file" class="form-control" id="save_file" name="file"> </div>'
			+ '<div class="select_img img"><img src="" /></div>'
			+ '<div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">정답</span> </div> <input type="text" class="form-control quiz-ans" name="quiz_ans"> </div> </div>'
		);
		$("#save_file").change(function(){
			   if(this.files && this.files[0]) {
			    var reader = new FileReader;
			    reader.onload = function(data) {
			     $(".select_img img").attr("src", data.target.result).width(500);        
			    }
			    reader.readAsDataURL(this.files[0]);
			   }
			  });
	});
	$('.4').click(function() {
		var maxNum = 4;
		var examNum = 0;
		$('.quiz1').remove();
		$('.quiz2').remove();
		$('.quiz3').remove();
		$('.quiz4').remove();
		$('.quiz').append(
			'<div class="quiz4"> <div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">문제</span> </div> <input type="text" class="form-control" name="quiz"> </div>'
			+ '<div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">파일첨부</span> </div> <input type="file" class="form-control" id="save_file" name="file"> </div>'
			+ '<div class="select_img img"><img src="" /></div>'
			+ '<div class="exam"> 보기 <br> </div> <input type="button" class="btn btn-outline-primary btn-sm examAdd" value="보기 추가">'
			+ '<div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">정답</span> </div> <input type="text" class="form-control quiz-ans" name="quiz_ans" placeholder="보기 중 정답번호만 입력해주세요."> </div> </div>'
		);
		$("#save_file").change(function(){
			   if(this.files && this.files[0]) {
			    var reader = new FileReader;
			    reader.onload = function(data) {
			     $(".select_img img").attr("src", data.target.result).width(500);        
			    }
			    reader.readAsDataURL(this.files[0]);
			   }
			  });
		$('.examAdd').click(function() {
			if(examNum < maxNum) {
			++examNum;
			var prevNum = examNum-1;
			$('.examRemove'+prevNum).hide();
			$('.exam').append(
				'<div class="ex'+examNum+'"><div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">'+examNum+' </span> </div> <input type="text" class="form-control exam'+examNum+'" name="quiz_exam"> <input type="button" class="btn btn-danger btn-sm examRemove'+examNum+'" value="삭제" ></div> </div>'
			);
			$('.examRemove'+examNum).click(function() {
				$('.ex'+examNum).remove();
				--examNum;
				$('.examRemove'+examNum).show();
			});
			} else {
				alert("보기는 최대 4개 까지 등록 가능합니다.");
			}
		});
	});

	</script>
		
		
		<div class="Btn">	
			<button type="submit" class="btn btn-outline-secondary btn-sm">문제제출</button>
			<input type="button" class="btn btn-outline-secondary btn-sm" value="그만하기" onclick="location.href='/';">
		</div>
		
		</form>
	</fieldset>
	</div>
	
	
	
	
	<%=request.getRealPath("/") %>
	
	<!-- <script>
	var quizNum = 1;
	$('.btnAdd').click(function() {
		++quizNum;
		$('.quizAdd').append(
			'<div class="quizForm'+quizNum+'"> <h3>퀴즈 '+quizNum+'</h3> <div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">카테고리</span> </div>'
			+ '<select name="category"> <option value="대회">대회</option> <option value="세계관">세계관</option> <option value="스킨">스킨</option> <option value="포지션">포지션</option> <option value="스킬">스킬</option> <option value="기본정보">기본정보</option> </select> </div>'
			+ '<div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">난이도</span> </div>'
			+ '<select name="category"> <option value="1">1</option> <option value="2">2</option> <option value="3">3</option> <option value="4">4</option> <option value="5">5</option>'
			+ '<option value="6">6</option> <option value="7">7</option> <option value="8">8</option> <option value="9">9</option> <option value="10">10</option> </select> </div>'
			+ '<div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">문제</span> </div> <input type="text" class="form-control" class="quiz'+quizNum+'" name="quiz"> </div>'			
			+ '<div class="check"> <input type="button" class="'+quizNum+'examAdd1" value="보기 추가"> </div>'
			+ '<div class="input-group-prepend"> <span class="input-group-text">정답</span> </div> <input type="text" class="form-control" class="quiz-ans'+quizNum+'" name="quiz-ans"> <hr> <input type="button" class="prev'+quizNum+'" value="이전 퀴즈"> <div class="next"></div> <br> <input type="button" class="quizRemove'+quizNum+'" value="문제 삭제"> </div>'
		);
		var prevNum = quizNum-1;
		var nextNum = quizNum+1;
		$('.quizForm'+prevNum).hide();
		$('.quizRemove'+quizNum).click(function() {
			$('.quizForm'+quizNum).remove();
			--quizNum;
			$('.quizForm'+quizNum).show();
		});
		$('.prev'+quizNum).click(function() {
			$('.quizForm'+quizNum).hide();
			--quizNum;
			$('.quizForm'+quizNum).show();
			$('.btnAdd').hide();
		});
	});
	
	
	</script> -->
	
	
	
	<!-- <script>
		var maxNum = 5;
		var num = 1;
		$('.btnAdd').click (function() {
			if(num < maxNum) {
			++num;
			$('.buttons').append (
				'<div class="quiz_'+num+'"> <h3>퀴즈 '+num+'</h3> <div class="input-group"> <div class="input-group-prepend"> <span class="input-group-text">카테고리</span> </div>'
				+' <select name="category"> <option value="대회">대회</option> <option value="세계관">세계관</option> <option value="스킨">스킨</option> <option value="포지션">포지션</option> <option value="스킬">스킬</option> <option value="기본정보">기본정보</option> </select> </div>'
				+'<div class="input-group"> <div class="input-group-prepend"> <span class="input-gorup-text">문제</span> </div> <input type="text" name="quiz'+ num +'"> </div> <div class="check'+num+'"></div> <input type="button" class="examAdd'+num+'" value="보기 추가"> <div class="input-group"> <div class="input-gorup-prepend"> <span class="input-gorup-text">정답</span> </div> <input type="text" name="quiz'+ num +'-ans"> </div>'
				+' <input type="button" class="btnRemove'+num+'" value="Remove"> <hr> </div>'
			);
			var temp_num = num-1;
			$('.btnRemove'+temp_num).hide();

			$('.examAdd'+num).click
			
			$('.btnRemove'+num).click (function() {
				$('.quiz_'+num).remove();
				--num;
				$('.btnRemove'+num).show();
				$('.btnAdd').show();
			}); 
			} else {
				alert("문제는 한 번에 5개 까지 등록가능합니다.");
				$('.btnAdd').hide();
			}
		});

		var maxENum = 4;
		var examNum = 0;
		$('.examAdd1').click(function() {
			++examNum;
			$('.check').append(
				'<div class="exam'+examNum+'"> '+examNum+' 번 <input type="text" name="exam'+examNum+'"> </div> <input type="button" class="examRemove'+examNum+'" value="삭제">'
			);

			var temp_examNum = examNum-1;
			$('.examRemove'+temp_examNum).hide();

			$('.examRemove'+examNum).click (function() {
				$('.exam'+examNum).remove();
				--examNum;
				$('.examRemove'+examNum).();
				$('.examAdd').show();
			});
				
		});
		

		

	</script> -->
	
</body>
</html>