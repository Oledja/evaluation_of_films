package com.prylipko.oleg.service.review;

import com.prylipko.oleg.domain.Review;
import com.prylipko.oleg.dto.review.CreateReviewRequest;
import com.prylipko.oleg.dto.review.PatchReviewRequest;
import com.prylipko.oleg.dto.review.ReadReviewResponse;
import com.prylipko.oleg.dto.review.UpdateReviewRequest;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.repository.ReviewRepository;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadReviewResponse getReview(UUID id) {
        Review review = repositoryHelper.getEntityRequired(Review.class, id);

        return translationService.translate(review, ReadReviewResponse.class);
    }

    public ReadReviewResponse createReview(CreateReviewRequest create) {
        Review review = translationService.translate(create, Review.class);
        review = reviewRepository.save(review);

        return translationService.translate(review, ReadReviewResponse.class);
    }

    public ReadReviewResponse patchReview(UUID id, PatchReviewRequest patch) {
        Review review = repositoryHelper.getEntityRequired(Review.class, id);
        translationService.map(patch, review);
        review = reviewRepository.save(review);

        return translationService.translate(review, ReadReviewResponse.class);
    }

    public ReadReviewResponse updateReview(UUID id, UpdateReviewRequest update) {
        Review review = repositoryHelper.getEntityRequired(Review.class, id);
        translationService.map(update, review);
        review = reviewRepository.save(review);

        return translationService.translate(review, ReadReviewResponse.class);
    }

    public void deleteReview(UUID id) {
        reviewRepository.delete(repositoryHelper.getEntityRequired(Review.class, id));
    }
}
