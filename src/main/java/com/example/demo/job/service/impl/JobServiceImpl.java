package com.example.demo.job.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.job.model.JobModule;
import com.example.demo.job.service.JobService;

@Service
public class JobServiceImpl implements JobService{

	private List<JobModule> jobs = new ArrayList<>();
	
	@Override
	public List<JobModule> findAll() {
		// TODO Auto-generated method stub
		return jobs;
	}

	@Override
	public void createJob(JobModule job) {
		job.setId((long)jobs.size()+1);
		jobs.add(job);
	}

}
