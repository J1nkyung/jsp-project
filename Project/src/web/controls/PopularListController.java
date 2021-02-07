package web.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import web.dao.BoardDao;

public class PopularListController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		BoardDao boardDao = (BoardDao)model.get("boardDao");

		HttpSession session = (HttpSession)model.get("session");
		session.setAttribute("popularInfo", boardDao.selectPopularList());
		session.setAttribute("noticeInfo", boardDao.selectNotice());
		
	    String id = (String) model.get("id");
	    if(id != "") {
	    	return "redirect:member/memberInfo.jsp";
	    }else {
	    	return "/index.jsp";
	    }

	}

}
