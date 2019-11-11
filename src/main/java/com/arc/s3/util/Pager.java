package com.arc.s3.util;

public class Pager {

	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	
	public Pager() {
		perPage = 10;
	}
	
	public Integer getTotalBlock() {
		return totalBlock;
	}

	public Integer getCurBlock() {
		return curBlock;
	}
	
	public Integer getStartNum() {
		return startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public Integer getCurPage() {
		if(this.curPage == null) {
			this.curPage = 1;
		}
		//curPage가 null값일 경우를 방지하기 위해서..
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
	public void makePager(int totalCount) {
		//1. 전체 글 개수 totalCount
		
		//2. 전체 페이지의 개수
		int totalPage = totalCount/perPage;
		if(totalCount%perPage != 0) {
			totalPage++;
		}
		
		//3. 전체 블럭의 개수
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		//4. curPage를 이용해서 curBlock 값 구하기
		curBlock = curPage/perBlock;
		if(curPage%perBlock != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 구하기
		startNum = (curBlock-1)*perBlock +1;
		lastNum = curBlock*perBlock;
		//현재 블럭이 마지막 블럭일 때, 마지막 번호는 전체 페이지 번호와 같게..
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
	}
	
	public RowMaker makeRow() {
		//rownum 계산
		int startRow = (this.getCurPage()-1)*perPage+1;
		//curPage가 null값일 경우를 방지하기 위해서..get으로 받아준다. set으로 받아도 됨.
		int lastRow = this.getCurPage()*perPage;
		
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		
		return rowMaker;
	}
}
