package com.udyog.bo;

import java.io.Serializable;

public class JobCategoryBo implements Serializable {
	private static final long serialVersionUID = 107191130404598200L;
	protected int jobCategoryNo;
	protected String categoryName;
	protected String description;

	public JobCategoryBo(int jobCategoryNo) {
		this.jobCategoryNo = jobCategoryNo;
	}

	public JobCategoryBo(int jobCategoryNo, String categoryName, String description) {
		super();
		this.jobCategoryNo = jobCategoryNo;
		this.categoryName = categoryName;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
