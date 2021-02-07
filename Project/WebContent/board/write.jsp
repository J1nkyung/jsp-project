<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>knitting community</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script>
	function titleCheck() {
		var f = document.getElementById("sBnt");
		theForm=document.writeform;
		if(theForm.title.value==""||theForm.contents.value==""){
			f.type = "reset";			
			alert("필수 입력란이 비었습니다. 확인 해주세요°ê¸°")
		}else{
			f.type = "submit";
			
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
					<jsp:include page="/member/loginInfo.jsp"/>
					<jsp:include page="search.jsp"/>
					<jsp:include page="board-list.jsp" />
				</div>
				<!--Left Block Ends -->
				<!--Right Block Starts -->
				<div id="right_block">
					<h1>글쓰기</h1>
					<form action='write.do?blno=${blno}' method='post' name="writeform">
   				<label>제목</label><br/>
               <input name="title" type="text" size="40" id="title"/><br/>
               <br/>
               <label>이미지 주소 창</label><br/>
               <input name="address" type="text" size="40" id="img"/><br/>
               <label>내용</label><br/>
               <textarea id="content" name="contents" rows="20" cols="70"></textarea>
				</div>
				<!--Right Block Ends -->
				<!--Content Block Ends -->
			</div>
				<input class="btn" type="reset" value="다시쓰기"/><input class="btn" type="submit" value="추가" onclick="titleCheck();" id="sBnt"/> 
			</form>
		</div>
		<jsp:include page="../footer.jsp" />
	</center>
</body>
</html>
