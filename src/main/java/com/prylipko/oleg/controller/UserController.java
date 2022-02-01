package com.prylipko.oleg.controller;

import com.prylipko.oleg.dto.user.CreateUserRequest;
import com.prylipko.oleg.dto.user.ReadUserResponse;
import com.prylipko.oleg.service.user.UserService;
import com.prylipko.oleg.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.ValidationException;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {

        return "registration";
    }


    @ResponseBody
    @GetMapping("/{id}")
    public ReadUserResponse getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }
    @ResponseBody
    @PostMapping("/create")
    public ReadUserResponse createUser (@RequestBody CreateUserRequest createUser, Errors errors) {
        userValidator.validate(createUser, errors);
        if (errors.hasErrors())
            throw new ValidationException(errors.getAllErrors().toString());
        return userService.createUser(createUser);
    }

}
