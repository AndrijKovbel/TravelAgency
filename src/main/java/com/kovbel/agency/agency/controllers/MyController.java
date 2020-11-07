package com.kovbel.agency.agency.controllers;

import com.kovbel.agency.agency.dao.DAO;
import com.kovbel.agency.agency.dao.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    DAO dao;

    @RequestMapping("/form")
    public String showform(Model model) {
        model.addAttribute("command", new Info());
        return "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Info info) {
        dao.save(info);
        return "redirect:/view";
    }

    @RequestMapping("/view")
    public String view(Model model) {
        List<Info> list = dao.getMyList();
        model.addAttribute("list", list);
        return "view";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Info info = dao.getEmpById(id);
        model.addAttribute("info", info);
        return "editform";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("info") Info info) {
        dao.update(info);
        return "redirect:/view";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "redirect:/view";
    }
}

