package eu.busi.projetPizza.controller;

import eu.busi.projetPizza.dataAcces.dao.CategorieDAO;
import eu.busi.projetPizza.dataAcces.dao.PizzaDAO;
import eu.busi.projetPizza.dataAcces.util.PizzaConveter;
import eu.busi.projetPizza.model.Constants;
import eu.busi.projetPizza.model.Ingredient;
import eu.busi.projetPizza.model.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

/**
 * created by  eric.nyandwi on Nov,11/11/2018
 */
@Controller
@RequestMapping(value = "/admin")
@SessionAttributes({Constants.CURRENT_USER , Constants.CURRENT_ENGREDIENT, Constants.CURRENT_Admin})
public class AdminController {

    private final CategorieDAO categorieDAO ;
    private  final PizzaDAO pizzaDAO;

    public AdminController(CategorieDAO categorieDAO, PizzaDAO pizzaDAO) {
        this.categorieDAO = categorieDAO;
        this.pizzaDAO = pizzaDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAdmin(Model model) {
        if(categorieDAO.getListCategories() != null) {
            model.addAttribute("categories", categorieDAO.getListCategories());
        }
        model.addAttribute("pizzas" , pizzaDAO.listPizza());
        return "integrated:managerpizza";
    }


    @ModelAttribute(Constants.CURRENT_PIZZA)
    public Pizza pizza() {
        return new Pizza();
    }


    @ModelAttribute(Constants.CURRENT_Admin)
    public Pizza pizza1() {
        return new Pizza();
    }

    @ModelAttribute(Constants.CURRENT_ENGREDIENT)
    public Ingredient ingredient() {
        return new Ingredient();
    }

    @RequestMapping(value = "managePizza/send", method = RequestMethod.POST)
    public String registerNewPizza(@Valid @ModelAttribute(value = Constants.CURRENT_Admin) Pizza pizza, final BindingResult errors) {
        System.out.println("*******************************************************" +
                "Name : " + pizza.getName() + "  " +
                "price  : " +pizza.getPrice() + "  " +
                "isFixed  : " + pizza.isFixed() + "  " +
                "moth_promo: " + pizza.isMonth_promo()
        );

        pizzaDAO.savePizza(PizzaConveter.pizzaModelTopizzaEntity(pizza));

        if (errors.hasErrors()) {
            return "integrated:managerpizza";
        }
        return "redirect:/managerpizza";
    }

    @RequestMapping(value = "/manage-stock", method = RequestMethod.GET)
    public String getStock(Model model) {
        model.addAttribute("categories",categorieDAO.getListCategories());
        model.addAttribute("pizzas" , pizzaDAO.loadAllPizza());
        return "integrated:managerstock";
    }

    @RequestMapping(value = "manage-stock/send", method = RequestMethod.POST)
    public String registerNewIngredient(@Valid @ModelAttribute(value = Constants.CURRENT_ENGREDIENT) Ingredient ingredient, final BindingResult errors) {
        System.out.println("*******************************************************" +
                "Name : " + ingredient.getName()
        );

        if (errors.hasErrors()) {
            return "integrated:managerstock";
        }
        return "redirect:/managerstock";
    }
}
