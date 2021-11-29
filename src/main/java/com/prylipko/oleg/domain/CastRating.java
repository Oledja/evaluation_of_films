package com.prylipko.oleg.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "cast_rating")
public class CastRating extends AbstractRating {

    @ManyToOne
    private Cast cast;
}
