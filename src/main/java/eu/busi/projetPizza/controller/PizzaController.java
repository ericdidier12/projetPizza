package eu.busi.projetPizza.controller;

/**
 * created by  eric.nyandwi on Nov,12/11/2018
 */

import eu.busi.projetPizza.dataAcces.dao.CategorieDAO;
import eu.busi.projetPizza.dataAcces.dao.PizzaDAO;
import eu.busi.projetPizza.dataAcces.entity.CategoryEntity;

import eu.busi.projetPizza.model.Category;
import eu.busi.projetPizza.model.Constants;

import eu.busi.projetPizza.model.Panier;
import eu.busi.projetPizza.model.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/pizza")
@SessionAttributes({Constants.CURRENT_USER, Constants.CURRENT_PIZZA, Constants.CURRENT_PIZZA, Constants.CURRENT_MY_MAP_PIZZA})
public class PizzaController {

    private final PizzaDAO pizzaDAO;
    private final CategorieDAO categorieDAO;

    public PizzaController(PizzaDAO pizzaDAO, CategorieDAO categorieDAO) {
        this.pizzaDAO = pizzaDAO;
        this.categorieDAO = categorieDAO;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String pizza(Model model) {
        model.addAttribute("categories", categorieDAO.getListCategories());
        model.addAttribute("pizzas", pizzaDAO.listPizza());
        return "integrated:pizza";
    }


    @RequestMapping(value = "/trieCategorieByName/{id}", method = RequestMethod.GET)
    public String triCategoryByName(@PathVariable(value = "id") String name, Model model) {
        System.out.println("affiche moi id " + name);
        CategoryEntity categoryEntity = categorieDAO.getCategoriyByName(name);
        model.addAttribute("categories", categorieDAO.getListCategories());
        List<Pizza> pizzas = pizzaDAO.findByCategoryEntity(categoryEntity);
        model.addAttribute("pizzas", pizzas);
        return "integrated:pizza";
    }

    @ModelAttribute(Constants.CURRENT_PIZZA)
    public Pizza pizza() {
        return new Pizza();
    }


    Map<Long, Pizza> pizzaHashMap = new HashMap<>();

    @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)
    public Map<Long, Pizza> pizzaMap() {
        return pizzaHashMap;
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String registerNewPizza(@Valid @ModelAttribute(value = Constants.CURRENT_CATEGORY) Category category, final BindingResult errors) {
        System.out.println("*******************************************************");
        if (errors.hasErrors()) {
            return "integrated:managerpizza";
        }
        return "redirect:/pizza";
    }

    @RequestMapping(value = "/ajouterAuPanier", method = RequestMethod.POST)
    public String chercherPizzas(Model model, @ModelAttribute(Constants.CURRENT_PIZZA) Pizza infospizza, final BindingResult errors) {

        Pizza pizza = pizzaDAO.findPizzaById(infospizza.getId());
        pizzaHashMap.put(infospizza.getId(), pizza);
        if (errors.hasErrors()) {

        }
        return "redirect:/pizza";
    }

}
