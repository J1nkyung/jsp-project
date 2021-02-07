package web.controls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import web.dao.BoardDao;
import web.vo.Board;
import web.vo.Paging;

public class PagingController implements Controller {
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int blno = (int) model.get("blno");
		BoardDao boardDao = (BoardDao)model.get("boardDao");
		
		// 컨트롤러에서 받았던 page를 가져온다. page는 처음 들어왔다면 1
		int page = (Integer)model.get("page");
		//게시판별 총 글의 갯수를 불러온다.
		int totalCount = boardDao.getTotalCount(blno);
		
		 Paging paging = new Paging();
		 //현재 페이지에 parameter 페이지의 값을 대입한다. 
		 paging.setCurPage(page); 
		 //setTotal함수를 실행시 total에 전체 게시글의 갯수를 대입하고 makePage()함수를 실행한다.
		 paging.setTotal(totalCount);
		 
		 // 한 페이지당 표시할 게시글의 수 (10개)
		 // sql쿼리문의 LIMIT은 1이 아니라 0부터 시작한다. 0번째부터 10개와 같다.
		 page = (page - 1) * 10;
		    
		 //게시판 글을 모두 불러온다 
		    model.put("list",boardDao.getList(page, paging.getRows(), blno));
		    model.put("paging",paging);
		    
		    
		    List<Board> comment = (List<Board>)model.get("list");
	          ArrayList<Integer> commentNum = new ArrayList<Integer>();

	          for (int i = 0; i < comment.size(); i++) {
//	             System.out.println(comment.get(i).getCno());
	             int cno = comment.get(i).getCno();
	             commentNum.add(boardDao.getCommentCount(cno));
	         }
	          
	          model.put("commentNum", commentNum);
		    
		    
		    return "/board/board.jsp";
	}
}
