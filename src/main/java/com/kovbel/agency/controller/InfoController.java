package com.kovbel.agency.controller;

import com.kovbel.agency.entity.Info;
import com.kovbel.agency.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InfoController {
    @Autowired
    InfoService infoService;


    @RequestMapping("/login")
    public String login (Model model) {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout (Model model) {
        return "logout";
    }

//    @RequestMapping("/form")
//    public String showform(Model model) {
//        model.addAttribute("command", new Info());
//        return "form";
//    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String save(@ModelAttribute Info info) {
//        infoService.save(info);
//        return "redirect:/view";
//    }

    @RequestMapping("/view")
    public String view(Model model) {
        List<Info> list = infoService.findAll();
        model.addAttribute("list", list);
        return "view";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Info info = infoService.findById(id);
        model.addAttribute("info", info);
        return "editform";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("info") Info info) {
        infoService.save(info);
        return "redirect:/view";
    }

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String delete(@PathVariable Long id) {
//        infoService.deleteById(id);
//        return "redirect:/view";
//    }

    @RequestMapping(value = "/get-country/{country}")
    public String getNameTour(@PathVariable String country, Model model) {
        List<Info> list = infoService.findAllByCountry(country);
        model.addAttribute("list", list);
        return "allcountry";
    }
}
