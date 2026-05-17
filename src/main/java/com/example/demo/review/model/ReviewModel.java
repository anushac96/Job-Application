package com.example.demo.review.model;

import com.example.demo.company.model.CompanyModule;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Review-Detail")
public class ReviewModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private double rating;
	
	@JsonIgnore
	@ManyToOne
	private CompanyModule company;	// foreign key
	
//	review_detail table contains company_id, so review own relationship
	
	public ReviewModel() {
		super();
	}

	public ReviewModel(Long id, String title, String description, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public double getRating() {
		return rating;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public CompanyModule getCompany() {
		return company;
	}

	public void setCompany(CompanyModule company) {
		this.company = company;
	}
}
