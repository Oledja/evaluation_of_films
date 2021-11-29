package com.prylipko.oleg.domain;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractRating extends AbstractEntity {

    @ManyToOne
    private User user;

    @Column(name = "rating")
    private int rating;
}
