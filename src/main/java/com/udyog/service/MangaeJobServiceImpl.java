package com.udyog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udyog.bo.CityBo;
import com.udyog.bo.JobBo;
import com.udyog.bo.JobCategoryBo;
import com.udyog.bo.StateBo;
import com.udyog.dao.JobDao;
import com.udyog.dto.CityDto;
import com.udyog.dto.JobCategoryDto;
import com.udyog.dto.JobDto;
import com.udyog.dto.StateDto;

@Service("firstService")
public class MangaeJobServiceImpl implements ManageJobService {
	@Autowired
	private JobDao jobDao;

	@Transactional(readOnly = true)
	@Override
	public List<JobDto> getJobs() {

		List<JobBo> jobBos = null;
		List<JobDto> jobDtos = null;

		jobBos = jobDao.getJobs();
		jobDtos = new ArrayList<>();
		for (JobBo bo : jobBos) {
			JobDto dto = new JobDto();
			BeanUtils.copyProperties(bo, dto);
			dto.setCity(new CityDto(bo.getCity().getCityNo(), bo.getCity().getCityName()));
			dto.setState(new StateDto(bo.getState().getStateNo(), bo.getState().getStateName()));
			dto.setJobCategory(
					new JobCategoryDto(bo.getJobCategory().getJobCategoryNo(), bo.getJobCategory().getCategoryName()));
			jobDtos.add(dto);
		}
		return jobDtos;
	}

	@Transactional(readOnly = true)
	@Override
	public JobDto getJob(int jobNo) {
		JobBo jobBo = null;
		JobDto jobDto = null;

		jobBo = jobDao.getJob(jobNo);
		jobDto = new JobDto();
		BeanUtils.copyProperties(jobBo, jobDto);
		jobDto.setCity(new CityDto(jobBo.getCity().getCityNo(), jobBo.getCity().getCityName()));
		jobDto.setState(new StateDto(jobBo.getState().getStateNo(), jobBo.getState().getStateName()));
		jobDto.setJobCategory(new JobCategoryDto(jobBo.getJobCategory().getJobCategoryNo(),
				jobBo.getJobCategory().getCategoryName()));
		return jobDto;
	}

	@Transactional(readOnly = false)
	@Override
	public int createJob(JobDto jobDto) {
		JobBo jobBo = null;
		int jobNo = 0;

		jobBo = new JobBo();
		BeanUtils.copyProperties(jobDto, jobBo);
		jobBo.setJobCategory(new JobCategoryBo(jobDto.getJobCategory().getJobCategoryNo()));
		jobBo.setCity(new CityBo(jobDto.getCity().getCityNo()));
		jobBo.setState(new StateBo(jobDto.getState().getStateNo()));

		jobBo.setStatus("A");
		jobBo.setJobPostedDate(new Date());

		jobNo = jobDao.saveJob(jobBo);
		return jobNo;
	}

	@Transactional(readOnly = false)
	@Override
	public void updateJob(JobDto jobDto) {
		JobBo jobBo = null;

		jobBo = new JobBo();
		BeanUtils.copyProperties(jobDto, jobBo);
		jobBo.setJobCategory(new JobCategoryBo(jobDto.getJobCategory().getJobCategoryNo()));
		jobBo.setCity(new CityBo(jobDto.getCity().getCityNo()));
		jobBo.setState(new StateBo(jobDto.getState().getStateNo()));
		jobDao.updateJob(jobBo);
	}

	@Transactional(readOnly = true)
	@Override
	public List<JobCategoryDto> getJobCategories() {
		List<JobCategoryBo> jobCategoryBos = null;
		List<JobCategoryDto> jobCategoryDtos = null;

		jobCategoryBos = jobDao.getJobCategories();
		jobCategoryDtos = new ArrayList<>();
		for (JobCategoryBo bo : jobCategoryBos) {
			JobCategoryDto dto = new JobCategoryDto(bo.getJobCategoryNo(), bo.getCategoryName());
			jobCategoryDtos.add(dto);
		}
		return jobCategoryDtos;
	}

	@Transactional(readOnly = true)
	@Override
	public List<CityDto> getCities() {
		List<CityBo> cityBos = null;
		List<CityDto> cityDtos = null;

		cityBos = jobDao.getCities();
		cityDtos = new ArrayList<>();
		for (CityBo bo : cityBos) {
			CityDto dto = new CityDto(bo.getCityNo(), bo.getCityName());
			cityDtos.add(dto);
		}
		return cityDtos;
	}

	@Transactional(readOnly = true)
	@Override
	public List<StateDto> getStates() {
		List<StateBo> stateBos = null;
		List<StateDto> stateDtos = null;

		stateBos = jobDao.getStates();
		stateDtos = new ArrayList<>();
		for (StateBo bo : stateBos) {
			StateDto dto = new StateDto(bo.getStateNo(), bo.getStateName());
			stateDtos.add(dto);
		}
		return stateDtos;
	}

}
