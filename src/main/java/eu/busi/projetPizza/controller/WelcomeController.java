package eu.busi.projetPizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "integrated:welcome";
    }


    @RequestMapping(value = "/tables", method = RequestMethod.GET)
    public String tab() {

        return "integrated:userInscription";
    }
}
