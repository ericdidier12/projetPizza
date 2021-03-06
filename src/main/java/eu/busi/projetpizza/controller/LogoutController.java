package eu.busi.projetpizza.controller;

import eu.busi.projetpizza.dataAcces.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

    @RequestMapping(method = RequestMethod.GET)
 public String getLogin(Model model) {
        model.addAttribute("userLogin",new UserEntity());
        return "redirect:/welcome";
  }
}
