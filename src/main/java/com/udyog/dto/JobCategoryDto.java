package com.udyog.dto;

public class JobCategoryDto {
	protected int jobCategoryNo;
	protected String categoryName;

	public JobCategoryDto(int jobCategoryNo) {
		super();
		this.jobCategoryNo = jobCategoryNo;
	}

	public JobCategoryDto(int jobCategoryNo, String categoryName) {
		super();
		this.jobCategoryNo = jobCategoryNo;
		this.categoryName = categoryName;
	}

	public int getJobCategoryNo() {
		return jobCategoryNo;
	}

	public void setJobCategoryNo(int jobCategoryNo) {
		this.jobCategoryNo = jobCategoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
