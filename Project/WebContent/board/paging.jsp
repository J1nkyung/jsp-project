<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css" />
<script>

function move(page){
    	location.href = "${pageContext.request.contextPath}/board/board.do?page="+page;
}
</script>

<div class="paging"
	style="position: absolute; width: 700px; height: 20px; text-align: center;">
	<ul class="pagination pagination-sm">
	
	<!-- paging vo 객체의 prev 필드가 true라면 "이전" 표시  -->
		<c:if test="${paging.prev}">
			<li class="page-item"><a class="page-link" href="#"
				onclick="move(${paging.beginNum-1})">이전</a></li>
		</c:if>
		<!-- index는 1씩 시작값인 begin페이지 번호부터 end번호까지 증가하면서 출력한다  -->
		<c:forEach var="index" begin="${paging.beginNum}"
			end="${paging.endNum}" step="1">
			
			<!-- 페이지 번호 출력 -->
				<li class="page-item"><a class="page-link" href="#"
					onclick="move(${index})">${index}</a></li>
		</c:forEach>
		
		<!-- paging vo 객체의 next 필드가 true라면 "다음" 표시  -->
		<c:if test="${paging.next}">
			<li class="page-item"><a class="page-link" href="#"
				onclick="move(${paging.endNum+1})">다음</a></li>
		</c:if>
	</ul>
</div>
