package com.example.demo.job;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
	private List<JobModule> jobs = new ArrayList<>();
	
	@GetMapping("/jobs")
	public List<JobModule> findAllJobs(){
		return jobs;
	}
	
	@PostMapping("/jobs")
	public String createJob(@RequestBody JobModule jobModule){
		jobs.add(jobModule);
		return "Job added successfully";
	}
}
