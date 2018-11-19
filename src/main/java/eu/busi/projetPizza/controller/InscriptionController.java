package eu.busi.projetPizza.controller;

import eu.busi.projetPizza.enums.RoleEnum;
import eu.busi.projetPizza.model.Constants;
import eu.busi.projetPizza.model.User;
import eu.busi.projetPizza.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

/**
 * created by  eric.nyandwi on Nov,07/11/2018
 */

@Controller
@RequestMapping("/user/register")
@SessionAttributes({Constants.CURRENT_USER})
public class InscriptionController {

    private final UserService userService;

    public InscriptionController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "integrated:registerUser";
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {
        return new User();
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String saveNewUserRegrister(@Valid @ModelAttribute(value ="currentUser") User user, final BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "integrated:registerUser";
        }
        userService.register(user, RoleEnum.USER);
        return "redirect:/login";
    }
}
