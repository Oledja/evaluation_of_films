package com.prylipko.oleg.service.movieRating;

import com.prylipko.oleg.domain.MovieRating;
import com.prylipko.oleg.dto.movieRating.CreateMovieRatingRequest;
import com.prylipko.oleg.dto.movieRating.PatchMovieRatingRequest;
import com.prylipko.oleg.dto.movieRating.ReadMovieRatingResponse;
import com.prylipko.oleg.dto.movieRating.UpdateMovieRatingRequest;
import com.prylipko.oleg.repository.MovieRatingRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovieRatingService {

    @Autowired
    private MovieRatingRepository movieRatingRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadMovieRatingResponse getMovieRating(UUID id) {
        MovieRating movieRating = repositoryHelper.getEntityRequired(MovieRating.class, id);

        return translationService.translate(movieRating, ReadMovieRatingResponse.class);
    }

    public ReadMovieRatingResponse createMovieRating(CreateMovieRatingRequest create) {
        MovieRating movieRating = translationService.translate(create, MovieRating.class);
        movieRating = movieRatingRepository.save(movieRating);

        return translationService.translate(movieRating, ReadMovieRatingResponse.class);
    }

    public ReadMovieRatingResponse patchMovieRating(UUID id, PatchMovieRatingRequest patch) {
        MovieRating movieRating = repositoryHelper.getEntityRequired(MovieRating.class, id);
        translationService.map(patch, movieRating);
        movieRating = movieRatingRepository.save(movieRating);

        return translationService.translate(movieRating, ReadMovieRatingResponse.class);
    }

    public ReadMovieRatingResponse updateMovieRating(UUID id, UpdateMovieRatingRequest update) {
        MovieRating movieRating = repositoryHelper.getEntityRequired(MovieRating.class, id);
        translationService.map(update, movieRating);
        movieRating = movieRatingRepository.save(movieRating);

        return translationService.translate(movieRating, ReadMovieRatingResponse.class);
    }

    public void deleteMovieRating(UUID id) {
        movieRatingRepository.delete(repositoryHelper.getEntityRequired(MovieRating.class, id));
    }
}
