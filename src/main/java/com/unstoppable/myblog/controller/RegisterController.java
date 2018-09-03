package com.unstoppable.myblog.controller;

import com.unstoppable.myblog.entity.User;
import com.unstoppable.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("user", new User());

        return "view/registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "view/registerForm";
        }
        if (userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist", true);
            return "view/registerForm";
        }
        userService.createUser(user);

        return "view/success";
    }

}
