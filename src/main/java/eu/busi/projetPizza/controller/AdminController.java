package eu.busi.projetPizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by  eric.nyandwi on Nov,11/11/2018
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(method = RequestMethod.GET)
    public String getAdmin(Model model) {
        return "integrated:managerorder";
    }
}
