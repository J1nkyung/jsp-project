<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>knitting community</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<div id="main_block">
			<!--Top Block Starts -->
			<jsp:include page="../header.jsp"/>
			<!--Top Block Ends -->
		</div>
		<div id="sub_block1">
			<!--Content Block Starts -->
			<div id="content_block">
				<!--Left Block Starts -->
				<div id="left_block">
				<jsp:include page="/member/loginInfo.jsp"/>		
				<jsp:include page="search.jsp"/>		
				<jsp:include page="/board/board-list.jsp"/>		
				</div>
				<!--Left Block Ends -->
				<!--Right Block Starts -->
		      <div id="right_block">
                <jsp:include page="/board/search-list.jsp"/>
           		<jsp:include page="searchPaging.jsp"/>
            </div>
            <!--Right Block Ends -->
            <!--Content Block Ends -->
			</div>
		</div>
			<jsp:include page="../footer.jsp"/>	
	</center>
</body>
</html>
