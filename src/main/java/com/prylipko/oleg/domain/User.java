package com.prylipko.oleg.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "t_user")
public class User extends AbstractEntity {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "country")
    private String country;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
