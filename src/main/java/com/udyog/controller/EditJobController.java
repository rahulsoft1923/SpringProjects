package com.udyog.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udyog.dto.CityDto;
import com.udyog.dto.JobCategoryDto;
import com.udyog.dto.JobDto;
import com.udyog.dto.StateDto;
import com.udyog.form.JobForm;
import com.udyog.service.ManageJobService;
import com.udyog.validator.JobFormValidator;

@Controller
@RequestMapping("/edit-job.htm")
public class EditJobController {
	@Autowired
	private JobFormValidator jobFormValidator;
	
	@Autowired
	@Qualifier("firstService")
	private ManageJobService manageJobService;

	@GetMapping
	public String showEditJobForm(@RequestParam("jobNo") int jobNo, Model model) {
		JobForm jobForm = null;
		JobDto jobDto = null;

		jobDto = manageJobService.getJob(jobNo);
		jobForm = new JobForm();
		BeanUtils.copyProperties(jobDto, jobForm);
		jobForm.setJobCategoryNo(jobDto.getJobCategory().getJobCategoryNo());
		jobForm.setCityNo(jobDto.getCity().getCityNo());
		jobForm.setStateNo(jobDto.getState().getStateNo());

		model.addAttribute("jobForm", jobForm);
		return "edit-job";
	}

	@PostMapping
	public String editJob(@ModelAttribute("jobForm") JobForm jobForm, BindingResult errors, Model model) {
		JobDto jobDto = null;

		if (jobFormValidator.supports(jobForm.getClass())) {
			jobFormValidator.validate(jobForm, errors);
		}
		if (errors.hasErrors()) {
			return "edit-job";
		}
		jobDto = new JobDto();
		BeanUtils.copyProperties(jobForm, jobDto);
		jobDto.setJobCategory(new JobCategoryDto(jobForm.getJobCategoryNo()));
		jobDto.setCity(new CityDto(jobForm.getCityNo()));
		jobDto.setState(new StateDto(jobForm.getStateNo()));

		manageJobService.updateJob(jobDto);
		model.addAttribute("title", jobForm.getTitle());

		return "redirect:jobs.htm?edited=1";
	}

	@ModelAttribute("jobCategories")
	public List<JobCategoryDto> jobCategories() {
		return manageJobService.getJobCategories();
	}

	@ModelAttribute("cities")
	public List<CityDto> cities() {
		return manageJobService.getCities();
	}

	@ModelAttribute("states")
	public List<StateDto> states() {
		return manageJobService.getStates();
	}
}
