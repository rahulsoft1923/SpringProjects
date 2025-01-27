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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.udyog.dto.CityDto;
import com.udyog.dto.JobCategoryDto;
import com.udyog.dto.JobDto;
import com.udyog.dto.StateDto;
import com.udyog.form.JobForm;
import com.udyog.service.ManageJobService;
import com.udyog.validator.JobFormValidator;

@Controller
@RequestMapping("/create-job.htm")
@SessionAttributes({ "job" })
public class PostJobFormController {
	@Autowired
	private JobFormValidator jobFormValidator;

	@Autowired
	@Qualifier("firstService")
	private ManageJobService manageJobService;
	
	
	@PostMapping
	public String postJob(@ModelAttribute("jobForm") JobForm jobForm, BindingResult errors, Model model) {
		int jobNo = 0;
		JobDto jobDto = null;

		if (jobFormValidator.supports(jobForm.getClass())) {
			jobFormValidator.validate(jobForm, errors);
		}
		if (errors.hasErrors()) {
			return "create-job";
		}
		jobDto = new JobDto();
		BeanUtils.copyProperties(jobForm, jobDto);

		jobDto.setJobCategory(new JobCategoryDto(jobForm.getJobCategoryNo()));
		jobDto.setCity(new CityDto(jobForm.getCityNo()));
		jobDto.setState(new StateDto(jobForm.getStateNo()));
		jobNo = manageJobService.createJob(jobDto);

		model.addAttribute("job", jobDto);
		model.addAttribute("jobNo", jobNo);

		return "redirect:jobs.htm?created=1";
	}
	
	@GetMapping
	public void showJobForm(Model model, @SessionAttribute(name = "job", required = false) JobDto job,
			SessionStatus sessionStatus) {
		JobForm jobForm = null;

		jobForm = new JobForm();
		model.addAttribute("jobForm", jobForm);
		if (job != null) {
			System.out.println(job.getTitle());
		}
		sessionStatus.setComplete();
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
