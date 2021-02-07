<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<meta charset="UTF-8">
<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();
		}
</script>
<form action="${pageContext.request.contextPath}/member/memberInfo.do" method="post">
<span class="blk1_lp"> 
	<span class="our">Member Login</span> 
	<span class="usr" style="margin-top: 12px;">User Login</span> 
	<input name="id" type="text" class="txbx" /> 
	<span class="usr">Password</span> 
	<input name="password" type="password" class="txbx" /> 
	<span class="chk">
	</span> 
	<br/>
	<input name="" type="submit" class="btn" style="margin-right:80px; margin-bottom:10px;" value="로그인" />
	<br/>
<span class="usr">회원이 아니신가요?
<a href='member/add.do'><b>가입하기</b></a></span>
</span>
</form>