package com.prylipko.oleg.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "role")
public class Role extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
