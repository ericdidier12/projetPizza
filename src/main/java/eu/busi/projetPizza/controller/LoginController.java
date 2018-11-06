package eu.busi.projetPizza.controller;

import eu.busi.projetPizza.dataAcces.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
public String getLogin(Model model) {
        model.addAttribute("toto",new UserEntity());
        return "integrated:login";
}
}
