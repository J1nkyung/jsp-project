package web.vo;

import java.sql.Date;

public class Board {

	protected int cno;
	protected int blno;
	protected String title;
	protected String contents;
	protected String id;
	protected Date regDate;
	protected int viewCount;
	protected int comno;
	protected String comment;
	protected Date comregDate;
	protected String image;
	
	public String getImage() {
		return image;
	}

	public Board setImage(String image) {
		this.image = image;
		return this;
	}

	public int getCno() {
		return cno;
	}

	public Board setCno(int cno) {
		this.cno = cno;
		return this;
	}

	public int getBlno() {
		return blno;
	}

	public Board setBlno(int blno) {
		this.blno = blno;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Board setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContents() {
		return contents;
	}

	public Board setContents(String contents) {
		this.contents = contents;
		return this;
	}

	public Date getRegDate() {
		return regDate;
	}

	public Board setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}

	public int getViewCount() {
		return viewCount;
	}

	public Board setViewCount(int viewCount) {
		this.viewCount = viewCount;
		return this;
	}

	public String getId() {
		return id;
	}

	public Board setId(String id) {
		this.id = id;
		return this;
	}

	public int getComno() {
		return comno;
	}

	public Board setComno(int comno) {
		this.comno = comno;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public Board setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public Date getComregDate() {
		return comregDate;
	}

	public Board setComregDate(Date comregDate) {
		this.comregDate = comregDate;
		return this;
	}

}
