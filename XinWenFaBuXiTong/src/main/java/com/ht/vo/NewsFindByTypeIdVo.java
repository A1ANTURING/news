package com.ht.vo;

import java.util.List;

public class NewsFindByTypeIdVo<T> {
	private List<T> data ;
	
	private String newsTitle ;
	
	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	private String startDate ;
	
	private String endDate ;
	
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

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	private int typeId ;
	private int pageNumber = 1;//当前页			页面传递过来
	private int totalRecord;//总条数		查询  count(*)
	private int pageSize = 8;//每页显示的数量	固定值
	private int totalPage;//总页数			计算出来 (int)Math.ceil(totalRecord*1.0/pageSize);
	
	public NewsFindByTypeIdVo(int pageNumber, int pageSize){
		this.pageNumber = pageNumber ;
		this.pageSize = pageSize ;
	}
	
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public NewsFindByTypeIdVo(){
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage() {
		return (int)Math.ceil(totalRecord*1.0/pageSize);
	}
	
	/**
	 * 获取开始索引
	 * @return
	 */
	public int getStartIndex(){
		return (pageNumber-1)*pageSize;
	}
}
