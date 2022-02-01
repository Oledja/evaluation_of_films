package com.prylipko.oleg.service.genre;

import com.prylipko.oleg.domain.Genre;
import com.prylipko.oleg.dto.genre.CreateGenreRequest;
import com.prylipko.oleg.dto.genre.PatchGenreRequest;
import com.prylipko.oleg.dto.genre.ReadGenreResponse;
import com.prylipko.oleg.dto.genre.UpdateGenreRequest;
import com.prylipko.oleg.repository.GenreRepository;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadGenreResponse getGenre(UUID id) {
        Genre genre = repositoryHelper.getEntityRequired(Genre.class, id);


        return translationService.translate(genre, ReadGenreResponse.class);
    }

    public ReadGenreResponse createGenre(CreateGenreRequest create) {
        Genre genre = translationService.translate(create, Genre.class);
        genre = genreRepository.save(genre);

        return translationService.translate(genre, ReadGenreResponse.class);
    }

    public ReadGenreResponse patchGenre(UUID id, PatchGenreRequest patch) {
        Genre genre = repositoryHelper.getEntityRequired(Genre.class, id);
        translationService.map(patch, genre);
        genre = genreRepository.save(genre);

        return translationService.translate(genre, ReadGenreResponse.class);
    }

    public ReadGenreResponse updateGenre(UUID id, UpdateGenreRequest update) {
        Genre genre = repositoryHelper.getEntityRequired(Genre.class, id);
        translationService.map(update, genre);
        genre = genreRepository.save(genre);

        return translationService.translate(genre, ReadGenreResponse.class);
    }

    public void deleteGenre(UUID id) {
        genreRepository.delete(repositoryHelper.getEntityRequired(Genre.class, id));
    }
}
