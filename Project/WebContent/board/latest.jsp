<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<meta charset="UTF-8">
<script>
	function check2(blno,cno){
		var id ='<%=(String)session.getAttribute("id")%>';
		console.log(id);
		
		if(id=="null"){
			alert("로그인해주세요");
		} else { 
			location.href="${pageContext.request.contextPath}/board/contents.do?blno="+blno+"&cno="+cno;
		}
	}
</script>
<span class="clnt">
	<span class="our">인기글</span> 
	<span class="lnk"> 
		<c:forEach var="popularInfo" items="${popularInfo}">
		<a href="#" onClick="check2(${popularInfo.blno},${popularInfo.cno});">${popularInfo.title}&emsp;[조회수:${popularInfo.viewCount}]<br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;[Date:${popularInfo.regDate}]<br/><br/></a>
		</c:forEach>
	</span> 
</span>

