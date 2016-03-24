package com.joye.health.model.common;

public class PageParam {

	private int startNum;
	private int endNum;
	private String startDate;
	private String endDate;

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public void constructPageNum(int offset, int limit){
		int startNum = offset + 1;
		int endNum = offset + limit;
		setStartNum(startNum);
		setEndNum(endNum);
	}
	
	public void constructDate(String date){
		constructDate(date,date);
	}
	
	public void constructDate(String startDate,String endDate){
		setStartDate(startDate + "000000000000");
		setEndDate(endDate + "235959999999");
	}

}
