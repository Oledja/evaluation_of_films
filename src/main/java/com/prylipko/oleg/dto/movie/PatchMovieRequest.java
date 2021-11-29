package com.prylipko.oleg.dto.movie;

import com.prylipko.oleg.dto.genre.ReadGenreResponse;
import com.prylipko.oleg.dto.productionCompany.ReadProductionCompanyResponse;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PatchMovieRequest {

    private String title;
    private String language;
    private List<ReadGenreResponse> genres;
    private List<ReadProductionCompanyResponse> productionCompanies;
    private int runningTime;
    private LocalDate release;
    private String description;
    private int budget;
    private int revenue;
}
