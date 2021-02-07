package web.vo;

public class Paging {
		private int total; // 전체 게시글 수 
		private int curPage=1; // 현재 페이지 
		private int totalPage; // 전체 페이지 수
		private int displayPage = 5; // 보여줄 페이지 번호의 총 개수 
		private int rows = 10; // 한 페이지당 보여줄 게시글 수 
		private int beginNum; // 페이지 시작번호 
		private int endNum; // 페이지 끝번호
		public boolean prev; // 이전 
		public boolean next; // 다음 
		
		
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
			makePage();
		}
		public int getCurPage() {
			return curPage;
		}
		public void setCurPage(int curPage) {
			this.curPage = curPage;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			
			this.totalPage = totalPage;
		}
		public int getDisplayPage() {
			return displayPage;
		}
		public void setDisplayPage(int displayPage) {
			this.displayPage = displayPage;
		}
		public int getRows() {
			return rows;
		}
		public void setRows(int rows) {
			this.rows = rows;
		}
		public int getBeginNum() {
			return beginNum;
		}
		public void setBeginNum(int beginNum) {
			this.beginNum = beginNum;
		}
		public int getEndNum() {
			return endNum;
		}
		public void setEndNum(int endNum) {
			this.endNum = endNum;
		}
		
		public boolean isPrev() {
			return prev;
		}
		public void setPrev(boolean prev) {
			this.prev = prev;
		}
		public boolean isNext() {
			return next;
		}
		public void setNext(boolean next) {
			this.next = next;
		}
		
		public void makePage() {
			//displayPage = 5 (한 페이지에 보여주고 싶은 페이지 넘버의 개수)
			//endNum = 한 페이지에 보이는 끝 번호
			//만약 curPage가 1~5중 하나라면 endNum은 5 
			endNum = ((int)Math.ceil(curPage/(double)displayPage))*displayPage;
			beginNum = endNum - (displayPage - 1);
			
			if(beginNum==1) {
				prev = false;
			} else if (beginNum>1){
				prev = true;
			}
			
			//표시될 페이지 수 구하기 
			//rows = 10 / total은 controller에서 set시켰던 수
	        int totalPage = (int)Math.ceil(total/(double)rows);
	        
	        //만약 글 갯수가 적어서 totalPage가 3이라면 endNum에 3을 대입하여 3까지만 표시되도록 한다.
	        if(totalPage<endNum){
	            endNum = totalPage;
	            next = false;
	        }else{
	            next = true;
	        }

	        this.setBeginNum(beginNum); 
	        this.setEndNum(endNum);
		}
}
