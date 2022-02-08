package com.RestAssured;

import java.util.ArrayList;

public class ListUserBase {
	public int page;

	public int per_page;

	public int total;

	public int total_pages;

	public ArrayList<SingleUserData> data;
	private Support support;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return per_page;
	}

	public void setPerPage(int perPage) {
		this.per_page = perPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPages() {
		return total_pages;
	}

	public void setTotalPages(int totalPages) {
		this.total_pages = totalPages;
	}

	public ArrayList<SingleUserData> getData() {
		return data;
	}

	public void setData(ArrayList<SingleUserData> data) {
		this.data = data;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}
}
