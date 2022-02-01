package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.review.CreateReviewRequest;
import com.prylipko.oleg.dto.review.PatchReviewRequest;
import com.prylipko.oleg.dto.review.ReadReviewResponse;
import com.prylipko.oleg.dto.review.UpdateReviewRequest;
import com.prylipko.oleg.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{id}")
    public ReadReviewResponse getCrew(@PathVariable UUID id) {
        return reviewService.getReview(id);
    }

    @PostMapping("/create")
    public ReadReviewResponse createCrew(@RequestBody CreateReviewRequest create) {
        return reviewService.createReview(create);
    }

    @PatchMapping("/{id}")
    public ReadReviewResponse patchCrew(@PathVariable UUID id, @RequestBody PatchReviewRequest patch) {
        return reviewService.patchReview(id, patch);
    }

    @PutMapping("/{id}")
    public ReadReviewResponse updateCrew(@PathVariable UUID id, @RequestBody UpdateReviewRequest update) {
        return reviewService.updateReview(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteCrew(@PathVariable UUID id) {
        reviewService.deleteReview(id);
    }
}
