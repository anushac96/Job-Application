package com.example.demo.review.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.company.model.CompanyModule;
import com.example.demo.company.repository.CompanyRepository;
import com.example.demo.company.service.CompanyService;
import com.example.demo.review.model.ReviewModel;
import com.example.demo.review.repository.ReviewRepository;
import com.example.demo.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;
	private CompanyRepository companyRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyRepository companyRepository) {
		super();
		this.reviewRepository = reviewRepository;
		this.companyRepository = companyRepository;
	}

	@Override
	public List<ReviewModel> findAll() {
		return reviewRepository.findAll();
	}

	@Override
	public void createReview(ReviewModel review) {
		reviewRepository.save(review);
	}

	@Override
	public ReviewModel getReviewById(Long companyId, Long reviewId) {
		return reviewRepository.findByCompanyIdAndId(companyId, reviewId);

		// or
//		return reviewRepository.findReviewsByCompanyId(companyId)
//		.stream()
//		.filter(review -> review.getId().equals(reviewId))
//		.findFirst()
//		.orElse(null);
	}

	@Override
	public boolean deleteReviewById(Long companyId, Long reviewId) {
		ReviewModel review = reviewRepository.findByCompanyIdAndId(companyId, reviewId);
		if (review != null) {
			reviewRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}

	@Override
	public void createReviewes(List<ReviewModel> reviewModels) {
		reviewRepository.saveAll(reviewModels);
	}

	@Override
	public boolean updateAReview(Long companyId, Long reviewId, ReviewModel reviewModel) {
		ReviewModel review = reviewRepository.findByCompanyIdAndId(companyId, reviewId);
		if (review != null) {
			review.setDescription(reviewModel.getDescription());
			review.setRating(reviewModel.getRating());
			review.setTitle(reviewModel.getTitle());
			review.setCompany(companyRepository.findById(companyId).get());
			reviewRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public List<ReviewModel> getReviewsByCompanyId(Long companyId) {
		List<ReviewModel> reviewsList = reviewRepository.findReviewsByCompanyId(companyId);
		return reviewsList;
	}

	@Override
	public boolean addReviewListByCompanyId(Long companyId, List<ReviewModel> reviewModels) {
		Optional<CompanyModule> companyOptional = companyRepository.findById(companyId);
		if (companyOptional.isPresent()) {
			CompanyModule company = companyOptional.get();
			for (ReviewModel review : reviewModels) {
				review.setCompany(company);
			}
			reviewRepository.saveAll(reviewModels);
			return true;
		}
		return false;
	}

	@Override
	public boolean addReviewByCompanyId(Long companyId, ReviewModel reviewModel) {
		Optional<CompanyModule> companyOptional = companyRepository.findById(companyId);
		if (companyOptional.isPresent()) {
			CompanyModule company = companyOptional.get();
			reviewModel.setCompany(company);
			reviewRepository.save(reviewModel);
			return true;
		}
		return false;
	}

}
