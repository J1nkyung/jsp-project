<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
.comm{font-size:14px;}

</style>
<script>

 	var temp = "";
 	
	function commentCheck(comno, cno, comment){
		var temp = comment;
		var input = document.getElementById("comment"+comno);
		 var update = document.getElementById("update"+comno); 
	    input.innerHTML = "<b><textarea name="+'comment'+" id="+'updates'+ " onkeyup="+'print()'+" rows="+3+" cols="+95+">"+temp+"</textarea>";
	   
	    if(input.value != ('comment'+comno)){update.id = "go";}
	    var go = document.getElementById("go"); 
	    
	    event.stopPropagation();
	    
	    
 	}
 	
	function print() {
		const com = document.getElementById('updates').value;
		temp = com;
		}

 	
	document.addEventListener('click', function(e){
 		if(e.target && e.target.id == 'go'){
 			/* var input = document.getElementById("updates").value; */
 			document.getElementById('updates').value = temp;

 			document.getElementById("go").type = "submit"; 
 			
 		}
 	}) 
 	
</script>
</head>
        <div id="comments" style="margin-top:100px;">
            <div id="comment-head" class="comment-row">
               <span id="comments-count">${fn:length(commentList)}</span> Comment(s)
            
            <!-- 댓글 입력 부분  -->
            <form action='comment.do?blno=${blno}&cno=${cno}' method='post'>
               <div style="margin-bottom : 50px;" class="comment-row">
                  <textarea id="content" name="new_comment" rows="3" cols="85"
                     placeholder="New Comment"></textarea>
                 <button style="float:right;"class="btn" type="submit" onClick="SubmitComment();">등록</button>
               </div>
                 <hr/>
            </form>
            </div>
            <!-- 댓글 출력되는 부분 -->
        <c:set var="loginId" value="${member.id}"/>
 		<c:forEach var="commentList" items="${commentList}">
 		    <div class="comment-row">
 		      <c:if test="${commentList.id eq loginId}">
    			<button class="btn" onclick='location.href="${pageContext.request.contextPath}/comment-delete.do?blno=${blno}&comno=${commentList.comno}&cno=${commentList.cno}"'>삭제</button>
               
              <form action='${pageContext.request.contextPath}/comment-update.do?blno=${blno}&comno=${commentList.comno}&cno=${commentList.cno}' method='post'>
               <input class="update" id="update${commentList.comno}" type="button" onclick="commentCheck(${commentList.comno}, ${commentList.cno}, '${commentList.comment}');" value="수정"/>
               </c:if>
                <div class="comment-date"> ${commentList.comregDate} <h4>[${commentList.id}]</h4></div>
               <div class="comm" id="comment${commentList.comno}">${commentList.comment}</div>
                </form>
          	</div>
          	<hr/>
 		</c:forEach>
         </div> 
      <jsp:include page="../footer.jsp" />
   </center>
</body>
</html>

