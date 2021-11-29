package com.prylipko.oleg.service.role;

import com.prylipko.oleg.domain.Role;
import com.prylipko.oleg.dto.role.CreateRoleRequest;
import com.prylipko.oleg.dto.role.PatchRoleRequest;
import com.prylipko.oleg.dto.role.ReadRoleResponse;
import com.prylipko.oleg.dto.role.UpdateRoleRequest;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.repository.RoleRepository;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    public ReadRoleResponse getRole(UUID id) {
        Role role = repositoryHelper.getEntityRequired(Role.class, id);

        return translationService.translate(role, ReadRoleResponse.class);
    }

    public ReadRoleResponse createRole(CreateRoleRequest create) {
        Role role = translationService.translate(create, Role.class);

        return translationService.translate(role, ReadRoleResponse.class);
    }

    public ReadRoleResponse patchRole(UUID id, PatchRoleRequest patch) {
        Role role = repositoryHelper.getEntityRequired(Role.class, id);
        translationService.map(patch, role);
        role = roleRepository.save(role);

        return translationService.translate(role, ReadRoleResponse.class);
    }

    public ReadRoleResponse updateRole(UUID id, UpdateRoleRequest update) {
        Role role = repositoryHelper.getEntityRequired(Role.class, id);
        translationService.map(update, role);
        role = roleRepository.save(role);

        return translationService.translate(role, ReadRoleResponse.class);
    }

    public void deleteRole(UUID id) {
        roleRepository.delete(repositoryHelper.getEntityRequired(Role.class, id));
    }
}
