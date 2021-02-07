<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="UTF-8">
<script>
	function check(a){
		var id ='<%=(String) session.getAttribute("id")%>';
		console.log(id);

		if (id == "null") {
			alert("로그인해주세요");
		} else {

			location.href = '${pageContext.request.contextPath}/board/board.do?blno='
					+ a;
		}
	}
</script>
<span class="blk2_lp" style="border:dashed black; border-width:1px 0px; border-radius:12px; width:120px; margin-top:60px; padding: 30px 15px 50px 15px; "> <span class="nws"></span>

		<span class="dat" style="margin-top: 22px;"> <span><a
				href="#" onClick="check(1);">공지사항</a></span><br />
		</span> <span class="dat"> <span><a href="#"
				onClick="check(2);">자유게시판</a></span><br />
		</span> <span class="dat"> <span><a href="#"
				onClick="check(3);">뜨개 자료공유</a></span><br />
		</span> <span class="dat"> <span><a href="#"
				onClick="check(4);">중고거래</a></span><br />
		</span>

</span>