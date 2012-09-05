package com.lsq.common.util;

public class Pager {
	private int pageCount;
	private int pageSize;
	public Pager() {
		super();
	}

	public Pager(int pageCount, int pageSize) {
		super();
		this.pageCount = pageCount;
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
