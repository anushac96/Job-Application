package com.example.demo.review.service;

import java.util.List;
import com.example.demo.review.model.ReviewModel;

public interface ReviewService {
	List<ReviewModel> findAll();
	void createReview(ReviewModel review);
	ReviewModel getReviewById(Long companyId, Long id);
	boolean deleteReviewById(Long companyId, Long id);
	void createReviewes(List<ReviewModel> reviewModels);
	boolean updateAReview(Long companyId, Long id, ReviewModel reviewModel);
	List<ReviewModel> getReviewsByCompanyId(Long companyId);
	boolean addReviewListByCompanyId(Long companyId, List<ReviewModel> reviewModels);
	boolean addReviewByCompanyId(Long companyId, ReviewModel reviewModels);
}
