package com.udyog.bo;

import java.io.Serializable;
import java.util.Date;

public class JobBo implements Serializable {
	private static final long serialVersionUID = -3913715481699710733L;
	protected int jobNo;
	protected String title;
	protected String description;
	protected String companyName;
	protected int experience;
	protected Date jobPostedDate;
	protected Date openingDate;
	protected Date closingDate;
	protected String skills;
	protected JobCategoryBo jobCategory;
	protected CityBo city;
	protected StateBo state;
	protected String country;
	protected String status;

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

	public Date getJobPostedDate() {
		return jobPostedDate;
	}

	public void setJobPostedDate(Date jobPostedDate) {
		this.jobPostedDate = jobPostedDate;
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

	public JobCategoryBo getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(JobCategoryBo jobCategory) {
		this.jobCategory = jobCategory;
	}

	public CityBo getCity() {
		return city;
	}

	public void setCity(CityBo city) {
		this.city = city;
	}

	public StateBo getState() {
		return state;
	}

	public void setState(StateBo state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
