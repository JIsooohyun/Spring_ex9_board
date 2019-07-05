package com.sh.util;

public class PagerMaker {
	private Integer curPage;  //레퍼런스 타입이라서 null이 들어갈 수 있다. 
	private String kind; 
	private String search;
	private int perPage=10;
	//rownum숫자 만들기 위해서 필요
	private int startRow;
	private int lastRow;
	
	//page
	private int totalBlock;
	private int curBlock;
	private int startNum;
	private int lastNum;
	
	
	
	
	public Integer getCurPage() {
		if(this.curPage==null) {
			this.curPage =1;
		}
		return curPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
		if(curPage==null) {
			this.curPage = 1;
		}
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search ="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getLastRow() {
		return lastRow;
	}

	//startRow, lastRow
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.perPage+1;
		this.lastRow = this.curPage*this.perPage;
	}
	
	public void makePage(int totalCount) {
		//1.전체 글 갯수
		//2. totalPage
		int totalPage = totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		
		//3. totalBlock
		int perBlock = 5;
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		//curPage를 이용해서 curBlock구하기
		this.curBlock = curPage/perBlock;
		if(this.curPage%perBlock!=0) {
			curBlock++;
		}
		
		//5. startNum과 lastNum구하기
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = (this.curBlock)*perBlock;
		
		//6. curBlock이 totalBlock일 때 
		if(this.curBlock==totalBlock) {
			this.lastNum = totalPage;
		}
	}
	
	
}









