package com.fpoly.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchOrderObject {

	private String status;
	private String startDate;
	private String endDate;

	public SearchOrderObject() {
		status = "";
		startDate = "";
		endDate = "";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	
	
}
