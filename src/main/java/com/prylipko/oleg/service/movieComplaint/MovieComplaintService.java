package com.prylipko.oleg.service.movieComplaint;

import com.prylipko.oleg.domain.MovieComplaint;
import com.prylipko.oleg.dto.movieComplaint.CreateMovieComplaintRequest;
import com.prylipko.oleg.dto.movieComplaint.PatchMovieComplaintRequest;
import com.prylipko.oleg.dto.movieComplaint.ReadMovieComplaintResponse;
import com.prylipko.oleg.dto.movieComplaint.UpdateMovieComplaintRequest;
import com.prylipko.oleg.repository.MovieComplaintRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovieComplaintService {

    @Autowired
    private MovieComplaintRepository movieComplaintRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadMovieComplaintResponse getMovieComplaint(UUID id) {
        MovieComplaint movieComplaint = repositoryHelper.getEntityRequired(MovieComplaint.class, id);

        return translationService.translate(movieComplaint, ReadMovieComplaintResponse.class);
    }

    public ReadMovieComplaintResponse createMovieComplaint(CreateMovieComplaintRequest create) {
        MovieComplaint movieComplaint = translationService.translate(create, MovieComplaint.class);
        movieComplaint = movieComplaintRepository.save(movieComplaint);

        return translationService.translate(movieComplaint, ReadMovieComplaintResponse.class);
    }

    public ReadMovieComplaintResponse patchMovieComplaint(UUID id, PatchMovieComplaintRequest patch) {
        MovieComplaint movieComplaint = repositoryHelper.getEntityRequired(MovieComplaint.class, id);
        translationService.map(patch, movieComplaint);
        movieComplaint = movieComplaintRepository.save(movieComplaint);

        return translationService.translate(movieComplaint, ReadMovieComplaintResponse.class);
    }

    public ReadMovieComplaintResponse updateMovieComplaint(UUID id, UpdateMovieComplaintRequest update) {
        MovieComplaint movieComplaint = repositoryHelper.getEntityRequired(MovieComplaint.class, id);
        translationService.map(update, movieComplaint);
        movieComplaint = movieComplaintRepository.save(movieComplaint);

        return translationService.translate(movieComplaint, ReadMovieComplaintResponse.class);
    }

    public void deleteMovieComplaint(UUID id) {
        movieComplaintRepository.delete(repositoryHelper.getEntityRequired(MovieComplaint.class, id));
    }
}
