package web.controls;

import java.util.Map;

import web.dao.BoardDao;

public class TitleListController implements Controller  {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		BoardDao boardDao = (BoardDao)model.get("boardDao");
		
		int blno = (int) model.get("blno");
		model.put("titleList", boardDao.selectList(blno));

		System.out.println("연결");
		return "/board.jsp";
		
	}	
	
}
