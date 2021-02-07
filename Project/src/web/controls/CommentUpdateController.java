package web.controls;

import java.util.Map;

import web.dao.BoardDao;
import web.vo.Board;

public class CommentUpdateController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Board board = (Board) model.get("commentInfo");
		BoardDao boardDao = (BoardDao)model.get("boardDao");
		boardDao.updateComment(board);
		model.put("commentList", boardDao.selectComment(board.getCno()));
		
		return "/board/contents.jsp";
	}

}
