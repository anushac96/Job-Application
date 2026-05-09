package com.example.demo.job.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.job.model.JobModule;
import com.example.demo.job.repository.JobRepository;
import com.example.demo.job.service.JobService;

@Service
public class JobServiceImpl implements JobService {

//	private List<JobModule> jobs = new ArrayList<>();

	JobRepository jobRepo;

	public JobServiceImpl(JobRepository jobRepo) {
		super();
		this.jobRepo = jobRepo;
	}
	

	@Override
	public List<JobModule> findAll() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

	@Override
	public void createJob(JobModule job) {
		jobRepo.save(job);
	}

	@Override
	public JobModule getJobById(Long id) {
		return jobRepo.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
		try {
			jobRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void createJobs(List<JobModule> jobModules) {
		jobRepo.saveAll(jobModules);
	}

	@Override
	public boolean updateAJob(Long id, JobModule job) {
		Optional<JobModule> jobOptional = jobRepo.findById(id);
			if (jobOptional.isPresent()) {
				JobModule j = jobOptional.get();
				j.setDescription(job.getDescription());
				j.setLocation(job.getLocation());
				j.setMaxSalary(job.getMaxSalary());
				j.setMinSalary(job.getMinSalary());
				j.setTitle(job.getTitle());
				jobRepo.save(j);
				return true;
			}
		
		return false;
	}
}
