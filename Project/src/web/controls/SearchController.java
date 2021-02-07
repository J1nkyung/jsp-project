package web.controls;

import java.util.Map;

import web.dao.BoardDao;
import web.vo.Paging;

public class SearchController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		BoardDao boardDao = (BoardDao)model.get("boardDao");
		String keyword = (String) model.get("keyword");
		
		// page는 처음 들어왔다면 1일 것이다.
		int page = (Integer)model.get("page");
		//게시판별 총 글의 갯수를 불러온다.
		int totalCount = boardDao.getCount(keyword);
		
		 Paging paging = new Paging();
		 //현재 페이지에 parameter 페이지의 값을 대입한다. 
		 paging.setCurPage(page); 
		 //setTotal함수를 실행시 total에 전체 게시글의 갯수를 대입하고 makePage()함수를 실행한다.
		 paging.setTotal(totalCount);
		 
		 // 한 페이지당 표시할 게시글의 수 (10개)
		 // sql쿼리문의 LIMIT은 1이 아니라 0부터 시작한다. 0번째부터 10개와 같다.
		 page = (page - 1) * 10;
		    
		 //SearchController에서는 파라미터로 받은 keyword를 넘겨 keyword가 포함된 글들을 불러온다.
		    model.put("searchList",boardDao.searchList(page, paging.getRows(),keyword));
		    model.put("paging",paging);
		    
		    return "/board/searchContents.jsp";
		
	}

}
