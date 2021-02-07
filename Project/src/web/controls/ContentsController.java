package web.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import web.dao.BoardDao;
import web.vo.Board;

public class ContentsController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		BoardDao boardDao = (BoardDao)model.get("boardDao");
		int cno = (Integer)model.get("cno");
		boardDao.updateVC(cno);
		Board board = boardDao.showContents(cno);
	
		HttpSession session = (HttpSession)model.get("session");
		session.setAttribute("content", board);

		//댓글 
		model.put("commentList", boardDao.selectComment(cno));
		
		return "/board/contents.jsp";
	
	}

}
