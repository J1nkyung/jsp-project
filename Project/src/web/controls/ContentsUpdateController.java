package web.controls;

import java.util.Map;

import web.dao.BoardDao;
import web.vo.Board;

public class ContentsUpdateController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		BoardDao boardDao = (BoardDao)model.get("boardDao");

		if(model.get("contentsUpdate")==null) {
			
			model.put("updateContent", boardDao.showContents((Integer)model.get("cno")));
			return "/board/update.jsp";
			
			
		}else {
			Board board = (Board)model.get("contentsUpdate");
			boardDao.update(board);
			return "redirect:board.do";
			
			
		}
		
	
	}

}
