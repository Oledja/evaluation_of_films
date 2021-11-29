package com.prylipko.oleg.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "review")
public class Review extends AbstractEntity {

    @ManyToOne
    private User author;

    @Column(name = "movie_id")
    private UUID movieId;

    @Column(name = "text")
    private String text;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
