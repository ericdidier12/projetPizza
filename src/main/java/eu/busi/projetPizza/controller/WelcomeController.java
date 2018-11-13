package eu.busi.projetPizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class WelcomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "integrated:welcome";
    }

}
