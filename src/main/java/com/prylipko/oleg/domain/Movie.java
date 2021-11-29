package com.prylipko.oleg.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "movie")
public class Movie extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "language")
    private String language;

    @ManyToMany
    @JoinTable(name = "movie_genres",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")})
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "movie_production_companies",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "production_company_id", referencedColumnName = "id")})
    private List<ProductionCompany> productionCompanies;

    @Column(name = "running_time")
    private int runningTime;

    @Column(name = "release")
    private LocalDate release;

    @Column(name = "description")
    private String description;

    @Column(name = "budget")
    private int budget;

    @Column(name = "revenue")
    private int revenue;

    @Column(name = "average_rating")
    private double averageRating;

    @Column(name = "vote_count")
    private int voteCount;
}
