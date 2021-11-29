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
@Table(name = "casts")
public class Cast extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
