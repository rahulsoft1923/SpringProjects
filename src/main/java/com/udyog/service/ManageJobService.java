package com.udyog.service;

import java.util.List;

import com.udyog.dto.CityDto;
import com.udyog.dto.JobCategoryDto;
import com.udyog.dto.JobDto;
import com.udyog.dto.StateDto;

public interface ManageJobService {
	List<JobDto> getJobs();

	JobDto getJob(int jobNo);

	int createJob(JobDto jobDto);

	void updateJob(JobDto jobDto);

	List<JobCategoryDto> getJobCategories();

	List<CityDto> getCities();

	List<StateDto> getStates();
}
