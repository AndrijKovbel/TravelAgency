package com.kovbel.agency.controller;

import com.kovbel.agency.entity.Info;
import com.kovbel.agency.entity.User;
import com.kovbel.agency.service.InfoService;
import com.kovbel.agency.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
public class InfoController {

    Logger logger = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    InfoService infoService;

    @Autowired
    UserService userService;



    @RequestMapping("/login")
    public String login(Model model) {
        User user = new User();
        return "login";
    }

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
        logger.warn("Somebody made edit in this field {}", info);
        return "redirect:/view";
    }


    @RequestMapping(value = "/get-country/{country}")
    public String getNameTour(@PathVariable String country, Model model) {
        List<Info> list = infoService.findAllByCountry(country);
        model.addAttribute("list", list);
        return "allcountry";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("message", "Hello " + user.getName()
                    + ", My friend you do not have permission to access this page. SORRY!");
        }
        model.setViewName("403");
        logger.info(user.getName() + " visited page which is closed for him!");
        return model;
    }




}


//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String delete(@PathVariable Long id) {
//        infoService.deleteById(id);
//        return "redirect:/view";
//    }


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


