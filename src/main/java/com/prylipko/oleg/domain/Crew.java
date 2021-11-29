package com.prylipko.oleg.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "crew")
public class Crew extends AbstractEntity {


    @Column(name = "job")
    private String job;

    @ManyToOne
    private Person person;
}
