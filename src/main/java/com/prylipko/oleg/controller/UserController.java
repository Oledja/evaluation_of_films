package com.prylipko.oleg.controller;

import com.prylipko.oleg.domain.User;
import com.prylipko.oleg.service.security.SecurityService;
import com.prylipko.oleg.service.user.UserService;
import com.prylipko.oleg.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService service;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

//    @PostMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
}
