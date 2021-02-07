package web.controls;

import java.util.Map;

import web.dao.BoardDao;

public class DeleteController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		BoardDao boardDao = (BoardDao)model.get("boardDao");
		int cno = (Integer)model.get("cno");
		int blno = (Integer)model.get("blno");
		
		boardDao.deleteOne(cno, blno);
		System.out.println(cno);
		System.out.println(blno);
		
		return "redirect:board.do";
	}

}
