package com.example.demo.review.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.review.model.ReviewModel;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {

	List<ReviewModel> findReviewsByCompanyId(Long companyId);

	ReviewModel findByCompanyIdAndId(Long companyId, Long id);

}
