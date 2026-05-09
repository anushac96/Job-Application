package com.example.demo.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.job.model.JobModule;

public interface JobRepository extends JpaRepository<JobModule, Long>{

}
