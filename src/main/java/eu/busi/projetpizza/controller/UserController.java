package eu.busi.projetpizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by  eric.nyandwi on Nov,07/11/2018
 */

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String getLogin(Model model) {
        model.addAttribute("message","Je suis incomplet veuillez me completer ");
        return "integrated:userConnecte";
    }


}
