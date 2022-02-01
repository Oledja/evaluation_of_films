package com.prylipko.oleg.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractRating extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "rating")
    private int rating;
}
