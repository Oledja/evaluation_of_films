package com.prylipko.oleg.validator;

import com.prylipko.oleg.domain.User;
import com.prylipko.oleg.dto.user.CreateUserRequest;
import com.prylipko.oleg.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateUserRequest createUser = (CreateUserRequest) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Required");
        if (createUser.getUserName() == null || createUser.getUserName().length() < 5 || createUser.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.userForm.username");
        }

        if (userService.findUserByUsername(createUser.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (createUser.getPassword().length() < 8 || createUser.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if(!createUser.getPasswordConfirm().equals(createUser.getPassword())) {
            errors.rejectValue("passwordConfirm", "Different.userForm.password");
        }
    }
}
