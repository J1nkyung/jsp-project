package web.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.controls.CommentDeleteContorller;
import web.controls.CommentUpdateController;
import web.controls.CommentWriteController;
import web.controls.ContentsController;
import web.controls.ContentsUpdateController;
import web.controls.Controller;
import web.controls.DeleteController;
import web.controls.LoginController;
import web.controls.LogoutController;
import web.controls.MemberJoinController;
import web.controls.PagingController;
import web.controls.PopularListController;
import web.controls.SearchController;
import web.controls.WriteController;
import web.vo.Board;
import web.vo.Member;

@WebServlet("*.do")
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
	String id = "";
	int blno = 0;
	int cno = 0;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		// pageController에 분기 전송을 위해 '서블릿 경로'를 얻는다
		String servletPath = request.getServletPath();
		
		try {
			
			HashMap<String, Object> model = new HashMap<String, Object>();
			ServletContext sc = this.getServletContext();
			Controller pageController = null;
			
			model.put("session", request.getSession());
			model.put("boardDao", sc.getAttribute("boardDao"));
			model.put("memberDao", sc.getAttribute("memberDao"));

				if ("/board/board.do".equals(servletPath)) {
					pageController = new PagingController();
					
				//처음 글 목록으로 들어갔을때 파라미터의 page는 null이므로 1을 대입한다.
					int page = request.getParameter("page")==null ?
							1:Integer.parseInt(request.getParameter("page"));
					model.put("page",page);
					
					
				if(request.getParameter("blno") == null) {
					model.put("blno", blno);
				}else {
					blno = Integer.parseInt(request.getParameter("blno"));
					model.put("blno", blno);
				}
					
			} else if ("/member/memberInfo.do".equals(servletPath)) {
				pageController = new LoginController();
				
				if(request.getParameter("id")!=null) {
					model.put("loginInfo",new Member().setId(request.getParameter("id"))
													  .setPwd(request.getParameter("password")));
					model.put("blno", blno);
					model.put("cno", cno);
					id = (String)request.getParameter("id");
				} else {
					System.out.println("id를 확인해주세요");
				}
	
			} else if ("/board/contents.do".equals(servletPath)) {
				pageController = new ContentsController();
				cno = Integer.parseInt(request.getParameter("cno"));
				blno = Integer.parseInt(request.getParameter("blno"));
				
				if(request.getParameter("cno")!=null) {
					model.put("cno", cno);
					model.put("blno", blno);
				}
				
			}else if ("/board/write.do".equals(servletPath)) {
				pageController = new WriteController();
				
				System.out.println(id);
				System.out.println(blno);
				
				if(request.getParameter("title")!=null) {
					System.out.println(id);
					model.put("writeInfo",new Board().setTitle(request.getParameter("title"))
												.setId(id)
												.setBlno(blno)
												.setContents(request.getParameter("contents"))
												.setImage(request.getParameter("address")));		
					
				}else {
					model.put("blno", blno);
				}
			} else if ("/board/board-delete.do".equals(servletPath)) {
				pageController = new DeleteController();
				
				if(request.getParameter("cno")!=null) {
					cno = Integer.parseInt(request.getParameter("cno"));
					model.put("cno", cno);
					model.put("blno", blno);
				}
			} else if ("/index.do".equals(servletPath) || "/home.do".equals(servletPath)){
				pageController = new PopularListController();
				
				System.out.println(id);
				if(id != null) {
					System.out.println(id);
					model.put("id", id);
				}
			}else if("/board/update.do".contentEquals(servletPath)){
				pageController = new ContentsUpdateController();
				model.put("cno", Integer.parseInt(request.getParameter("cno")));

				
				if(request.getParameter("title")!=null) {
					System.out.println(request.getParameter("blno"));
					
				model.put("contentsUpdate",new Board()
						.setTitle(request.getParameter("title"))
						.setId(id)
						.setCno(Integer.parseInt(request.getParameter("cno")))
						.setBlno(Integer.parseInt(request.getParameter("blno")))
						.setContents(request.getParameter("contents")));						
				}
				
			} else if("/logout.do".equals(servletPath)) {
				pageController = new LogoutController();
				id = "";
				
			} else if("/board/comment.do".equals(servletPath)) {
				pageController = new CommentWriteController();
				if(request.getParameter("new_comment") != null) {
					model.put("commentInfo", new Board().setComment(request.getParameter("new_comment"))
														.setCno(cno)
														.setId(id));
					model.put("blno",Integer.parseInt(request.getParameter("blno")));
				}
			}else if("/comment-delete.do".equals(servletPath)){
				pageController = new CommentDeleteContorller();
				if(request.getParameter("comno") != null) {
					model.put("commentInfo",  new Board().setComno(Integer.parseInt(request.getParameter("comno")))
														 .setCno(Integer.parseInt(request.getParameter("cno"))));  
					model.put("blno",Integer.parseInt(request.getParameter("blno")));
					
				}
			}else if("/comment-update.do".equals(servletPath)) {
				pageController = new CommentUpdateController();
				if(request.getParameter("comno") != null) {
					model.put("commentInfo",  new Board().setComno(Integer.parseInt(request.getParameter("comno")))
							 .setCno(Integer.parseInt(request.getParameter("cno")))
							 .setComment(request.getParameter("comment")));  
					model.put("blno",Integer.parseInt(request.getParameter("blno")));
				}
			}else if("/member/add.do".equals(servletPath)) {
				pageController = new MemberJoinController();
				
				if(request.getParameter("id")!=null) {
					
					System.out.println(request.getParameter("id"));
					
					model.put("member", new Member()
							.setId(request.getParameter("id"))
							.setEmail(request.getParameter("email"))
							.setPwd(request.getParameter("pwd"))
							.setMname(request.getParameter("mname"))
							);
				}
				
			} else if("/board/search.do".equals(servletPath)) {
				pageController = new SearchController();
				
				int page = request.getParameter("page")==null ?
						1:Integer.parseInt(request.getParameter("page"));
				model.put("page",page);
				
				if(request.getParameter("keyword")!=null) {
					model.put("keyword", request.getParameter("keyword"));
				}
				
			}
			
			String viewUrl = "";
			
			if (pageController != null) {

				viewUrl = pageController.execute(model);

				for (String key : model.keySet()) {
					request.setAttribute(key, model.get(key));
					
				}		
			} else {
				System.out.println("주소 대상 Controller가 없습니다!");
			}
		
			
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();


		}
	}

	
}