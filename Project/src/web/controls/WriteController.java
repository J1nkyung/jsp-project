package web.controls;

import java.util.Map;

import web.dao.BoardDao;
import web.vo.Board;

public class WriteController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Board board = (Board)model.get("writeInfo");
		

		if(model.get("writeInfo")==null) {  //get
			return "/board/write.jsp";
			
		} else { //post
			int blno = board.getBlno();
			BoardDao boardDao = (BoardDao)model.get("boardDao");
			boardDao.insertWrite(board);
			model.put("titleList", boardDao.selectList(blno));
			
			return "redirect:board.do";
		}

	}

}
