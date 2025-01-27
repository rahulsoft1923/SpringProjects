package com.udyog.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class JobForm {
	protected int jobNo;
	protected String title;
	protected String description;
	protected String companyName;
	protected int experience;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	protected Date openingDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	protected Date closingDate;
	protected String skills;
	protected int cityNo;
	protected int stateNo;
	protected String country;
	protected int jobCategoryNo;

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getCityNo() {
		return cityNo;
	}

	public void setCityNo(int cityNo) {
		this.cityNo = cityNo;
	}

	public int getStateNo() {
		return stateNo;
	}

	public void setStateNo(int stateNo) {
		this.stateNo = stateNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getJobCategoryNo() {
		return jobCategoryNo;
	}

	public void setJobCategoryNo(int jobCategoryNo) {
		this.jobCategoryNo = jobCategoryNo;
	}

}
