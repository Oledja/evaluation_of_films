package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.reviewComplaint.CreateReviewComplaintRequest;
import com.prylipko.oleg.dto.reviewComplaint.PatchReviewComplaintRequest;
import com.prylipko.oleg.dto.reviewComplaint.ReadReviewComplaintResponse;
import com.prylipko.oleg.dto.reviewComplaint.UpdateReviewComplaintRequest;
import com.prylipko.oleg.service.reviewComplaint.ReviewComplaintService;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/review-complaints")
public class ReviewComplaintController {

    private ReviewComplaintService reviewComplaintService;

    @GetMapping("/{id}")
    public ReadReviewComplaintResponse getCrew(@PathVariable UUID id) {
        return reviewComplaintService.getReviewComplain(id);
    }

    @PostMapping("/create")
    public ReadReviewComplaintResponse createCrew(@RequestBody CreateReviewComplaintRequest create) {
        return reviewComplaintService.createReviewComplaint(create);
    }

    @PatchMapping("/{id}")
    public ReadReviewComplaintResponse patchCrew(@PathVariable UUID id, @RequestBody PatchReviewComplaintRequest patch) {
        return reviewComplaintService.patchReviewComplaint(id, patch);
    }

    @PutMapping("/{id}")
    public ReadReviewComplaintResponse updateCrew(@PathVariable UUID id, @RequestBody UpdateReviewComplaintRequest update) {
        return reviewComplaintService.updateReviewComplaint(id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteCrew(@PathVariable UUID id) {
        reviewComplaintService.deleteReviewComplaint(id);
    }
}
