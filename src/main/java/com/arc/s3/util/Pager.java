package com.arc.s3.util;

public class Pager {

	private Integer curPage; //해당 글이 속한 페이지
	private Integer perPage; //페이지당 글 개수
	private Integer totalPage; //전체 페이지 개수
	private Integer startNum; //시작 글번호
	private Integer lastNum; //마지막 글번호
	private Integer curBlock; //현재 페이지가 속한 블록
	private Integer perBlock; //블록당 페이지 개수
	private Integer totalBlock; //전체 블록 수
	
	public Pager() {
		perPage = 10;
	}

	public Integer getCurPage() {
		if(this.curPage == null) {
			this.curPage = 1;
		}
		
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPerPage() {
		return perPage;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}
	
	public RowMaker makeRow() {
		int startRow = (this.getCurPage()-1)*perPage +1;
		int lastRow = this.getCurPage()*perPage;
		
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		
		return rowMaker;
	}
	
	public void makePager(int totalCount) {
		totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}
		
		perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		curBlock = curPage/perBlock;
		if(curPage%perBlock != 0) {
			curBlock++;
		}
		
		startNum = (curBlock-1)*perBlock +1;
		lastNum = curBlock*perBlock;
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
	}
}
