package com.example.demo.review.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.review.model.ReviewModel;
import com.example.demo.review.service.ReviewService;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@GetMapping()
	public ResponseEntity<List<ReviewModel>> findAll() {
		return new ResponseEntity<>(reviewService.findAll(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<String> createAReview(@RequestBody ReviewModel reviewModel) {
		return new ResponseEntity<String>("Review created successfully", HttpStatus.OK);
	}

	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<ReviewModel> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {
		ReviewModel review = reviewService.getReviewById(companyId, reviewId);
		if (review != null)
			return new ResponseEntity<ReviewModel>(review, HttpStatus.OK);
		return new ResponseEntity<ReviewModel>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId,
			@PathVariable Long companyId) {
		if (reviewService.deleteReviewById(companyId, reviewId))
			return new ResponseEntity<String>("Review deleted successfully", HttpStatus.OK);
		return new ResponseEntity<String>("Review not found", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/reviewList")
	public ResponseEntity<String> createReviewList(@RequestBody List<ReviewModel> reviewModels) {
		reviewService.createReviewes(reviewModels);
		return new ResponseEntity<String>("Reviews created successfully", HttpStatus.OK);
	}

	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateAReview(@PathVariable Long reviewId, @RequestBody ReviewModel reviewModel,
			@PathVariable Long companyId) {
		if (reviewService.updateAReview(companyId, reviewId, reviewModel)) {
			return new ResponseEntity<String>("Review updated successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Review not found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/reviews")
	public ResponseEntity<List<ReviewModel>> getReviewsByCompanyId(@PathVariable Long companyId) {
		return new ResponseEntity<List<ReviewModel>>(reviewService.getReviewsByCompanyId(companyId), HttpStatus.OK);
	}

	@PostMapping("/reviews")
	public ResponseEntity<String> addReviewListByCompanyId(@PathVariable Long companyId,
			@RequestBody List<ReviewModel> reviewModels) {
		if (reviewService.addReviewListByCompanyId(companyId, reviewModels))
			return new ResponseEntity<>("Reviews added successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Company id not found", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/review")
	public ResponseEntity<String> addReviewByCompanyId(@PathVariable Long companyId,
			@RequestBody ReviewModel reviewModels) {
		if (reviewService.addReviewByCompanyId(companyId, reviewModels))
			return new ResponseEntity<>("Reviews added successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Company id not found", HttpStatus.NOT_FOUND);
	}

}
