package com.prylipko.oleg.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "credit")
public class Credit extends AbstractEntity {

    @Column(name = "movie_id")
    private UUID movieId;

    @OneToMany
    @JoinTable(name = "credit_casts",
            joinColumns = {@JoinColumn(name = "credit_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "cast_id", referencedColumnName = "id")})
    private List<Cast> casts;

    @ManyToMany
    @JoinTable(name = "credit_crews",
            joinColumns = {@JoinColumn(name = "credit_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "crew_id", referencedColumnName = "id")})
    private List<Crew> crews;




}
