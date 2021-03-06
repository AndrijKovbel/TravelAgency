package com.kovbel.agency.controller;

import com.kovbel.agency.entity.Info;
import com.kovbel.agency.service.InfoService;
import com.kovbel.agency.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);


    @Autowired
    private UserService userService;

    @Autowired
    private InfoService infoService;


    @RequestMapping("/form")
    public String showform(Model model) {
        model.addAttribute("command", new Info());
        return "form";
    }

    @RequestMapping("/admin")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Info info) {
        infoService.save(info);
        logger.info("Added new information in row {}", info);
        return "redirect:/view";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        infoService.deleteById(id);
        logger.warn("Deleted position {}",infoService.toString());
        return "redirect:/view";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
            logger.warn("Admin deleted user from user list");
        }

        return "redirect:/admin";

    }
}
