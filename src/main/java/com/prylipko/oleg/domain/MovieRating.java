package com.prylipko.oleg.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "movie_rating")
public class MovieRating extends AbstractRating {

    @ManyToOne
    private Movie movie;
}
