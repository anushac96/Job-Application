package com.example.demo.job.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.job.model.JobModule;
import com.example.demo.job.service.JobService;

@RestController
@RequestMapping("/jobApplication")
public class JobController {
	
	private JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping("/jobs")
	public ResponseEntity<List<JobModule>> findAllJobs(){
		return ResponseEntity.ok(jobService.findAll());
	}
	
	@PostMapping("/job")
	public ResponseEntity<String> createAJob(@RequestBody JobModule jobModule){
		jobService.createJob(jobModule);
		return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
	}
	
	@PostMapping("/jobList")
	public ResponseEntity<String> createJobs(@RequestBody List<JobModule> jobModules){
		jobService.createJobs(jobModules);
		return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/job/{id}")
	public ResponseEntity<JobModule> getJobModuleById(@PathVariable Long id) {
		JobModule job = jobService.getJobById(id); 
		if(job!=null) {
			return new ResponseEntity<>(job, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/job/{id}")
	public ResponseEntity<String> deleteJobModuleById(@PathVariable Long id) {
		if(jobService.deleteJobById(id)) {
			return new ResponseEntity<>("Job deleted Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Job id is not presnt",HttpStatus.NOT_FOUND);
	}

	@PutMapping("job/{id}")
	public ResponseEntity<String> updatAJob(@PathVariable Long id, 
			@RequestBody JobModule job){
		if(jobService.updateAJob(id,job)) {
			return new ResponseEntity<>("Job updated Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Job not Found", HttpStatus.NOT_FOUND);
	}
}
