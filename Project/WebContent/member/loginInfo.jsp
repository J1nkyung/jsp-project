<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div style="border:1px solid none; padding:5px; margin:20px 40px 10px 20px; ">

				 <p style="font-size:14px; line-height:normal ;">아이디: ${member.id}
				 <br/><strong>${member.mname}</strong>님 환영합니다</p> 
    </div>
    
<button style=" float:right; margin:20px 80px 30px 0px;" class="logout" onclick='location.href="${pageContext.request.contextPath}/logout.do"; alert("로그아웃 되셨습니다");'>로그아웃</button>