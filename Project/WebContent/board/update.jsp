<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>knitting community</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
					<h1>수정하기</h1>
					<!--  <form action='write.do?blno=${requestScope.blno}' method='post'>-->
					<form action='update.do?blno=${updateContent.blno}&cno=${updateContent.cno}' method='post'>
					
					<label>제목</label> <br/>
                     <input name="title" type="text" size="40" value="${updateContent.title}"/>
                     <br/>   <br/>
                     <label for="content">내용</label><br/> <textarea id="content"
                           name="contents" rows="20" cols="70">${updateContent.contents}</textarea>
					
				</div>
				<!--Right Block Ends -->
				<!--Content Block Ends -->
			</div>
						<input class="update" type="button" value="돌아가기" onclick='location.href="${pageContext.request.contextPath}/board/contents.do?blno=${updateContent.blno}&cno=${updateContent.cno}";'/>
						<input class="update" type="submit" value="저장하기"/> 
						</form>

		</div>
		<jsp:include page="../footer.jsp" />
	</center>
</body>
</html>