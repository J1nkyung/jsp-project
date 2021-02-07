<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<meta charset="UTF-8">
<style>
.container {
	width: 700px;
}

.table>thead>tr>#titles {
	width: 50px;
}
</style>
<span class="blks"> <!-- <span class="special"> -->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>조회수</th>
						</tr>
					<thead>
					<tbody>
						<c:set var="Board" value="${list}" />
						<c:set var="commentNum" value="${commentNum}" />
						<c:forEach var="Board" items="${list}" varStatus="status">
							<tr>
								<td id="titles"><a
									href='contents.do?blno=${Board.blno}&cno=${Board.cno}'>${Board.title}</a>
									[ ${commentNum[status.index]} ]</td>
								<td>${Board.id}</td>
								<td>${Board.regDate}</td>
								<td>${Board.viewCount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</span>