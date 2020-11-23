package com.kovbel.agency.controller;

import com.kovbel.agency.entity.Info;
import com.kovbel.agency.service.InfoService;
import com.kovbel.agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private InfoService infoService;


    @RequestMapping("/form")
    public String showform(Model model) {
        model.addAttribute("command", new Info());
        return "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Info info) {
        infoService.save(info);
        return "redirect:/view";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        infoService.deleteById(id);
        return "redirect:/view";
    }

    @RequestMapping("/admin")
    public String showAllUsers(Model model){
        model.addAttribute("allUsers",userService.allUsers());
        return "admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model){
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
}
