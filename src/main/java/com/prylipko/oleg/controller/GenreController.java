package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.genre.CreateGenreRequest;
import com.prylipko.oleg.dto.genre.PatchGenreRequest;
import com.prylipko.oleg.dto.genre.ReadGenreResponse;
import com.prylipko.oleg.dto.genre.UpdateGenreRequest;
import com.prylipko.oleg.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/id")
    public ReadGenreResponse getGenre(@PathVariable UUID id) {
        return genreService.getGenre(id);
    }

    @PostMapping
    public ReadGenreResponse createGenre(@RequestBody CreateGenreRequest create) {
        return genreService.createGenre(create);
    }

    @PatchMapping("/id")
    public ReadGenreResponse patchGenre(@PathVariable UUID id,
                                        @RequestBody PatchGenreRequest patch) {
        return genreService.patchGenre(id, patch);
    }

    @PutMapping("/id")
    public ReadGenreResponse updateGenre(@PathVariable UUID id,
                                         @RequestBody UpdateGenreRequest update) {
        return genreService.updateGenre(id, update);
    }

    @DeleteMapping("/id")
    public void deleteGenre(@PathVariable UUID id) {
        genreService.deleteGenre(id);
    }
}
