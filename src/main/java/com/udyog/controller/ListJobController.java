package com.udyog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udyog.dto.JobDto;
import com.udyog.service.ManageJobService;

@Controller
public class ListJobController {
	@Autowired
	@Qualifier("firstService")
	private ManageJobService ManageJobService;

	@RequestMapping("/jobs.htm")
	public String showJobs(Model model) {
		List<JobDto> jobs = null;

		jobs = ManageJobService.getJobs();
		model.addAttribute("jobs", jobs);
		return "jobs";
	}
}
