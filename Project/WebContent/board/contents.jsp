<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>게시글 보기</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/css/style.css"
   rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"/>
<style type="">
p{font-size:14px;}
.line{font-size:16px; display:block;}
img{ height:300px; }
.buttons{
display:inline-block;
position::absolute;
float:right;
margin-bottom:100px;}
</style>
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
               <jsp:include page="/member/loginInfo.jsp" />
               <jsp:include page="search.jsp"/>
               <jsp:include page="board-list.jsp" />
            </div>
            <!--Left Block Ends -->
            <!--Right Block Starts -->
            <div id="right_block">
              <div class="panel panel-default" style=" height:550px;">
	 		 	<div class="panel-heading">
	 		 	<h3 class="panel-title">${content.title}</h3>
	 		 	</div>
	  				<div class="panel-body" style="padding:20px;">
			               <p>작성자 : ${content.id}</p>
			               <p>등록일 : ${content.regDate}</p>
			               <p>조회수 : ${content.viewCount}</p>
			               <hr/>
		            <!--    <div style="height auto; max-width: 900px; margin-bottom: 20px; padding: 10px 10px;"> -->
		             <c:choose>
		             	<c:when test="${empty content.image}">
		              </c:when>
		              <c:otherwise>
		              	<img src="${content.image}"/>
		              </c:otherwise>
		              </c:choose>
           		    </div>
                  <p class="line">&nbsp;&nbsp;&nbsp;${content.contents}</p>
	  			</div>
				</div>
           
            <!--Right Block Ends -->
            <!--Content Block Ends -->
            <br/>
            <div class="buttons">
            <button style=" margin-right:50px;" class="btn" onclick='location.href="${pageContext.request.contextPath}/board/board.do?blno=${blno}"'>글목록</button>
            <c:set var="loginId" value="${member.id}" />
            <c:if test="${content.id eq loginId}">
               <button class="btn"
                  onclick='location.href="${pageContext.request.contextPath}/board/board-delete.do?cno=${cno}&blno=${blno}"'>삭제</button>
            </c:if>
            <c:if test="${content.id eq loginId}">
               <button class="update"
                  onclick='location.href="${pageContext.request.contextPath}/board/update.do?blno=${blno}&cno=${content.cno}"'>수정하기</button>
            </c:if>
            </div>
         </div>
       <jsp:include page="comment.jsp"/>   
       </div>
       </center>
</body>
</html>