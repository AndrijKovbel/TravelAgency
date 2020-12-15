package com.kovbel.agency.controller;


import com.kovbel.agency.entity.User;
import com.kovbel.agency.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(InfoController.class);


    @RequestMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Sorry but your Passwords are don't match. Please be careful and try again.");
            logger.error("User wrote Password  which don't match in registration page");
            return "registration";
        }
        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "User already exists");
            logger.error("Somebody wanted registration username which are busy at the moment");
            return "registration";
        }
        return "redirect:/";
    }
}