package com.example.demo.company.model;

import java.util.List;

import com.example.demo.job.model.JobModule;
import com.example.demo.review.model.ReviewModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comapny-Detail")
public class CompanyModule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "company")
	private List<JobModule> jobs;
	
	@OneToMany(mappedBy = "company")
	private List<ReviewModel> reviews;
	
	public CompanyModule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyModule(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<JobModule> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobModule> jobs) {
		this.jobs = jobs;
	}

	public List<ReviewModel> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewModel> reviews) {
		this.reviews = reviews;
	}
	
}
