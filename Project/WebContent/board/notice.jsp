<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<script>
	function check1(blno,cno){
		var id ='<%=(String)session.getAttribute("id")%>';
		console.log(id);
		
		if(id=="null"){
			alert("로그인해주세요");
		} else { 
			
			location.href="${pageContext.request.contextPath}/board/contents.do?blno="+blno+"&cno="+cno;
		}
	}
</script>
 <span class="special">
	<span class="our">공지 사항 </span> 
		<span class="lnk">
		<c:forEach var="noticeInfo" items="${noticeInfo}">
		<a href="#" onClick="check1(${noticeInfo.blno},${noticeInfo.cno});">${noticeInfo.title}<br/>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;[date:${noticeInfo.regDate}]<br/><br/></a>
		</c:forEach>
 </span>
</span>