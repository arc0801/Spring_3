package com.arc.s3.util;

public class RowMaker {

	private int startRow;
	private int lastRow;
	
	private String kind;
	private String search;
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
}
