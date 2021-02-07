<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>knitting community</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
	function joinCheck() {
		var btn = document.getElementById("joinBtn");
		var joinForm = document.getElementById("joinForm");
		if(joinForm.id.value==""||joinForm.email.value=="" || joinForm.pwd.value=="" || joinForm.mname.value==""){
			btn.type = "reset";			
			alert("필수 입력란이 비었습니다. 확인 해주세요 °ê¸°")
		}else{
			btn.type = "submit";
			alert("회원가입이 완료되었습니다!");
		}
	}
</script>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<div id="main_block">
			<!--Top Block Starts -->
			<jsp:include page="../header.jsp" />
			<!--Top Block Ends -->
		</div>
		<div id="sub_block1">
			<!--Content Block Starts -->
			<div id="content_block">
				<!--Left Block Starts -->
				<div id="left_block">
					<jsp:include page="login.jsp"/>
					<jsp:include page="/board/board-list.jsp" />
				</div>
				<!--Left Block Ends -->
				<!--Right Block Starts -->
				<div id="right_block">
				<div id="join" >
					<h1>회원 등록</h1>
					<br/>
					<form id="joinForm" action='add.do' method='post'>
						<label style="width:200px;">아이디:</label> <input type='text' name='id'/><br/><br/>
						<label style="width:200px;">email:</label> <input type='text' name='email'/><br/><br/>
						<label style="width:200px;">암호 : </label><input type='password' name='pwd'/><br/><br/>
						<label style="width:200px;">이름 : </label><input type='text' name='mname'/><br/><br/>
						<input class="btn" type='reset' value='취소'/>
						<input id="joinBtn" class="btn" type='submit' onclick="joinCheck();" value='회원가입'/>
					</form>
				</div>
					</div>
				<!--Right Block Ends -->
				<!--Content Block Ends -->
			</div>
		</div>
		<jsp:include page="../footer.jsp" />
	</center>
</body>
</html>
