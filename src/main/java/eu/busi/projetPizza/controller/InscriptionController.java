package eu.busi.projetPizza.controller;

import eu.busi.projetPizza.model.Constants;
import eu.busi.projetPizza.model.User;
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
@RequestMapping("account/register")
@SessionAttributes({Constants.CURRENT_USER})
public class InscriptionController {

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "integrated:registerUser";
    }


    /***
     *
     * @param user  // objet User qui sera tag lorsque le formulaire sera rempli c-à-d Objet User est mis (garder) dans le Sessiion_Attribute
     * @param errors  // Type d'errors qu'on peut avoir dans nos champs si on a defini Validation cote Modele
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@Valid @ModelAttribute(value =Constants.CURRENT_USER) User user, final BindingResult errors) {

        if (errors.hasErrors()) {
            return "integrated:keyError";
        }

        return "redirect:/login";
    }
}
