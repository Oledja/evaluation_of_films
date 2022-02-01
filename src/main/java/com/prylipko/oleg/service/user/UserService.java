package com.prylipko.oleg.service.user;

import com.prylipko.oleg.domain.Role;
import com.prylipko.oleg.domain.User;
import com.prylipko.oleg.dto.user.CreateUserRequest;
import com.prylipko.oleg.dto.user.PatchUserRequest;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import com.prylipko.oleg.dto.user.UpdateUserRequest;
import com.prylipko.oleg.repository.RepositoryHelper;
import com.prylipko.oleg.repository.RoleRepository;
import com.prylipko.oleg.repository.UserRepository;
import com.prylipko.oleg.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RepositoryHelper repositoryHelper;

    @Autowired
    private TranslationService translationService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public ReadUserResponse getUser(UUID id) {
        User user = repositoryHelper.getEntityRequired(User.class, id);

        return translationService.translate(user, ReadUserResponse.class);
    }

    public ReadUserResponse createUser(CreateUserRequest create) {

        create.setPassword(bCryptPasswordEncoder.encode(create.getPassword()));

        User user = translationService.translate(create, User.class);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findRoleByName("USER"));
        user.setRoles(roles);
        user = userRepository.save(user);

        return translationService.translate(user, ReadUserResponse.class);
    }

    public ReadUserResponse findUserByUsername(String username) {
        User user = userRepository.findUserByUserName(username);
        if (user != null) {
            return translationService.translate(user, ReadUserResponse.class);
        }
        return null;
    }

    public ReadUserResponse patchUser(UUID id, PatchUserRequest patch) {
        User user = repositoryHelper.getEntityRequired(User.class, id);
        translationService.map(patch, user);
        user = userRepository.save(user);

        return translationService.translate(user, ReadUserResponse.class);
    }

    public ReadUserResponse updateUser(UUID id, UpdateUserRequest update) {
        User user = repositoryHelper.getEntityRequired(User.class, id);
        translationService.map(update, user);
        user = userRepository.save(user);

        return translationService.translate(user, ReadUserResponse.class);
    }

    public void deleteUser(UUID id) {
        userRepository.delete(repositoryHelper.getEntityRequired(User.class, id));
    }
}
