package com.prylipko.oleg.repository;

import com.prylipko.oleg.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public interface RoleRepository extends CrudRepository<Role, UUID> {

    Role findRoleByName(String name);
}
