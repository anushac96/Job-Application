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

	@Override
	public JobModule getJobById(Long id) {
		for(JobModule job:jobs) {
			if(job.getId() == id) {
				return job;
			}
		}
		return null;
	}

	@Override
	public boolean deleteJobById(Long id) {
		for(JobModule job:jobs) {
			if(job.getId() == id) {
				return jobs.remove(job);
			}
		}
		return false;
	}

	@Override
	public void createJobs(List<JobModule> jobModules) {
		for(JobModule job: jobModules) {
			job.setId((long)jobs.size()+1);
			jobs.add(job);
		}	
	}

	
	@Override
	public boolean updateAJob(Long id, JobModule job) {
		for(JobModule j: jobs) {
			if(j.getId() == id) {
				j.setDescription(job.getDescription());
				j.setLocation(job.getLocation());
				j.setMaxSalary(job.getMaxSalary());
				j.setMinSalary(job.getMinSalary());
				j.setTitle(job.getTitle());
				return true;
			}
		}
		return false;
	}
}
