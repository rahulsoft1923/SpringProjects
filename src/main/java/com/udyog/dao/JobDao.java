package com.udyog.dao;

import java.util.List;

import com.udyog.bo.CityBo;
import com.udyog.bo.JobBo;
import com.udyog.bo.JobCategoryBo;
import com.udyog.bo.StateBo;

public interface JobDao {
	List<JobBo> getJobs();

	int saveJob(JobBo job);

	void updateJob(JobBo job);

	JobBo getJob(int jobNo);

	List<JobCategoryBo> getJobCategories();

	List<CityBo> getCities();

	List<StateBo> getStates();
}
