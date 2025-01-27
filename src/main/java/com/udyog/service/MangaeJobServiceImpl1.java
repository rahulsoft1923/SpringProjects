package com.udyog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udyog.dto.CityDto;
import com.udyog.dto.JobCategoryDto;
import com.udyog.dto.JobDto;
import com.udyog.dto.StateDto;

@Service("secondService")
public class MangaeJobServiceImpl1 implements ManageJobService {

	@Override
	public List<JobDto> getJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobDto getJob(int jobNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createJob(JobDto jobDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateJob(JobDto jobDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JobCategoryDto> getJobCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDto> getCities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateDto> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

}
