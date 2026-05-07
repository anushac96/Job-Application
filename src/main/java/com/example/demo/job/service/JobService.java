package com.example.demo.job.service;

import java.util.List;

import com.example.demo.job.model.JobModule;

public interface JobService {
	List<JobModule> findAll();
	void createJob(JobModule job);
}
