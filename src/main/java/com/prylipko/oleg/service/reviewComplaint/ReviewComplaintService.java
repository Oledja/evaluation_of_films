package com.prylipko.oleg.service.reviewComplaint;

import com.prylipko.oleg.domain.ReviewComplaint;
import com.prylipko.oleg.dto.reviewComplaint.CreateReviewComplaintRequest;
import com.prylipko.oleg.dto.reviewComplaint.PatchReviewComplaintRequest;
import com.prylipko.oleg.dto.reviewComplaint.ReadReviewComplaintResponse;
import com.prylipko.oleg.dto.reviewComplaint.UpdateReviewComplaintRequest;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.repository.ReviewComplaintRepository;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ReviewComplaintService {

    @Autowired
    private ReviewComplaintRepository reviewComplaintRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadReviewComplaintResponse getReviewComplain(UUID id) {
        ReviewComplaint reviewComplaint = repositoryHelper.getEntityRequired(ReviewComplaint.class, id);

        return translationService.translate(reviewComplaint, ReadReviewComplaintResponse.class);
    }

    public ReadReviewComplaintResponse createReviewComplaint(CreateReviewComplaintRequest create) {
        ReviewComplaint reviewComplaint = translationService.translate(create, ReviewComplaint.class);
        reviewComplaint = reviewComplaintRepository.save(reviewComplaint);

        return translationService.translate(reviewComplaint, ReadReviewComplaintResponse.class);
    }

    public ReadReviewComplaintResponse patchReviewComplaint(UUID id, PatchReviewComplaintRequest patch) {
        ReviewComplaint reviewComplaint = repositoryHelper.getEntityRequired(ReviewComplaint.class, id);
        translationService.map(patch, reviewComplaint);
        reviewComplaint = reviewComplaintRepository.save(reviewComplaint);

        return translationService.translate(reviewComplaint, ReadReviewComplaintResponse.class);
    }

    public ReadReviewComplaintResponse updateReviewComplaint(UUID id, UpdateReviewComplaintRequest update) {
        ReviewComplaint reviewComplaint = repositoryHelper.getEntityRequired(ReviewComplaint.class, id);
        translationService.map(update, reviewComplaint);
        reviewComplaint = reviewComplaintRepository.save(reviewComplaint);

        return translationService.translate(reviewComplaint, ReadReviewComplaintResponse.class);
    }

    public void deleteReviewComplaint(UUID id) {
        reviewComplaintRepository.delete(repositoryHelper.getEntityRequired(ReviewComplaint.class, id));
    }
}
