package com.prylipko.oleg.service.movie;

import com.prylipko.oleg.domain.Movie;
import com.prylipko.oleg.dto.movie.CreateMovieRequest;
import com.prylipko.oleg.dto.movie.PatchMovieRequest;
import com.prylipko.oleg.dto.movie.ReadMovieResponse;
import com.prylipko.oleg.dto.movie.UpdateMovieRequest;
import com.prylipko.oleg.repository.MovieRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadMovieResponse getMovie(UUID id) {
        Movie movie = repositoryHelper.getEntityRequired(Movie.class, id);

        return translationService.translate(movie, ReadMovieResponse.class);
    }

    public ReadMovieResponse createMovie(CreateMovieRequest create) {
        Movie movie = translationService.translate(create, Movie.class);
        movie = movieRepository.save(movie);

        return translationService.translate(movie, ReadMovieResponse.class);
    }

    public ReadMovieResponse patchMovie(UUID id, PatchMovieRequest patch) {
        Movie movie = repositoryHelper.getEntityRequired(Movie.class, id);
        translationService.map(patch, movie);
        movie = movieRepository.save(movie);

        return translationService.translate(movie, ReadMovieResponse.class);
    }

    public ReadMovieResponse updateMovie(UUID id, UpdateMovieRequest update) {
        Movie movie = repositoryHelper.getEntityRequired(Movie.class, id);
        translationService.map(update, movie);
        movie = movieRepository.save(movie);

        return translationService.translate(movie, ReadMovieResponse.class);
    }

    public void deleteMovie(UUID id) {
        movieRepository.delete(repositoryHelper.getEntityRequired(Movie.class, id));
    }

}
