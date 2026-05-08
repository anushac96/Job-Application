package com.example.demo.job.service;

import java.util.List;

import com.example.demo.job.model.JobModule;

public interface JobService {
	List<JobModule> findAll();
	void createJob(JobModule job);
	JobModule getJobById(Long id);
	boolean deleteJobById(Long id);
	void createJobs(List<JobModule> jobModules);
	boolean updateAJob(Long id, JobModule job);
}
