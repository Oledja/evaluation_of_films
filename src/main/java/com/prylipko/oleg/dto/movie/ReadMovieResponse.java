package com.prylipko.oleg.dto.movie;

import com.prylipko.oleg.dto.genre.ReadGenreResponse;
import com.prylipko.oleg.dto.productionCompany.ReadProductionCompanyResponse;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class ReadMovieResponse {

    private UUID id;
    private String title;
    private String language;
    private List<ReadGenreResponse> genres;
    private List<ReadProductionCompanyResponse> productionCompanies;
    private int runningTime;
    private LocalDate release;
    private String description;
    private int budget;
    private int revenue;
    private double averageRating;
    private int voteCount;
    private Instant createdAt;
    private Instant updatedAt;
}
