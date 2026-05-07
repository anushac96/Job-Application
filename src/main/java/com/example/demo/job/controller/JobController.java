package com.example.demo.job.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.job.model.JobModule;
import com.example.demo.job.service.JobService;


@RestController
public class JobController {
	
	private JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping("/jobs")
	public List<JobModule> findAllJobs(){
		return jobService.findAll();
	}
	
	@PostMapping("/jobs")
	public String createJob(@RequestBody JobModule jobModule){
		jobService.createJob(jobModule);
		return "Job added successfully";
	}
}
