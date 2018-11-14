package eu.busi.projetPizza.controller;

/**
 * created by  eric.nyandwi on Nov,12/11/2018
 */

import eu.busi.projetPizza.dataAcces.dao.CategorieDAO;
import eu.busi.projetPizza.dataAcces.dao.IngredientDAO;
import eu.busi.projetPizza.dataAcces.dao.PizzaDAO;
import eu.busi.projetPizza.dataAcces.entity.CategoryEntity;

import eu.busi.projetPizza.dataAcces.util.generator.NameGenerator;
import eu.busi.projetPizza.model.Category;
import eu.busi.projetPizza.model.Constants;

import eu.busi.projetPizza.model.Ingredient;
import eu.busi.projetPizza.model.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/pizza")
@SessionAttributes({Constants.CURRENT_USER, Constants.CURRENT_PIZZA, Constants.CURRENT_PIZZA, Constants.CURRENT_MY_MAP_PIZZA, Constants.CURRENT_PIZZA_Custom})
public class PizzaController {

    private final PizzaDAO pizzaDAO;
    private final CategorieDAO categorieDAO;
    private final IngredientDAO ingredientDAO;

    public PizzaController(PizzaDAO pizzaDAO, CategorieDAO categorieDAO, IngredientDAO ingredientDAO) {
        this.pizzaDAO = pizzaDAO;
        this.categorieDAO = categorieDAO;
        this.ingredientDAO = ingredientDAO;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String pizza(Model model) {

        model.addAttribute("categories", categorieDAO.getListCategories());
        model.addAttribute("pizzas", pizzaDAO.listPizza());
        model.addAttribute("ingredients", ingredientDAO.getAllIngredients());
        return "integrated:pizza";
    }


    @RequestMapping(value = "/trieCategorieByName/{id}", method = RequestMethod.GET)
    public String triCategoryByName(@PathVariable(value = "id") String name, Model model) {

        CategoryEntity categoryEntity = categorieDAO.getCategoriyByName(name);
        model.addAttribute("categories", categorieDAO.getListCategories());
        model.addAttribute("ingredients", ingredientDAO.getAllIngredients());
        List<Pizza> pizzas = pizzaDAO.findByCategoryEntity(categoryEntity);
        model.addAttribute("pizzas", pizzas);
        return "integrated:pizza";
    }

    @ModelAttribute(Constants.CURRENT_PIZZA)
    public Pizza pizza() {
        return new Pizza();
    }

    @ModelAttribute(Constants.CURRENT_PIZZA_Custom)
    public Pizza pizzaCustom() {
        return new Pizza();
    }


    Map<Long, Pizza> pizzaHashMap = new HashMap<>();

    @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)
    public Map<Long, Pizza> pizzaMap() {
        return pizzaHashMap;
    }


    @RequestMapping(value = "/ajouterAuPanier", method = RequestMethod.POST)
    public String lookPizzasAndAddinCart(Model model, @ModelAttribute(Constants.CURRENT_PIZZA) Pizza infospizza, final BindingResult errors) {

        Pizza pizza = pizzaDAO.findPizzaById(infospizza.getId());
        if (pizzaHashMap.get(pizza.getId()) != null) {
            pizza.setNumber(pizza.getNumber() + infospizza.getNumber());
        } else {
            pizza.setNumber(infospizza.getNumber());
        }
        pizzaHashMap.put(infospizza.getId(), pizza);
        if (errors.hasErrors()) {

        }
        return "redirect:/pizza";
    }

    @ModelAttribute("webFrameworkList")
    public List<String> getWebFrameworkList() {
        List<String> webFrameworkList = new ArrayList<>();
        for (Ingredient ingredient : ingredientDAO.getAllIngredients()) {
            webFrameworkList.add(ingredient.getName());
        }
        return webFrameworkList;
    }


    @RequestMapping(value = "/ajouterAuPanierPizzaCustom", method = RequestMethod.POST)
    public String lookPizzaCustomsAndAddinCart(Model model, @ModelAttribute("webFrameworkList") Pizza infospizza, final BindingResult errors) {
        Pizza pizzaCustom = infospizza;
        if (errors.hasErrors()) {

        }
        return "redirect:/pizza";
    }


}
