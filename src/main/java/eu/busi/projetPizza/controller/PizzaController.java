package eu.busi.projetPizza.controller;

/**
 * created by  eric.nyandwi on Nov,12/11/2018
 */

import eu.busi.projetPizza.dataAcces.dao.CategoryDAO;
import eu.busi.projetPizza.dataAcces.dao.IngredientDAO;
import eu.busi.projetPizza.dataAcces.dao.PizzaDAO;
import eu.busi.projetPizza.dataAcces.entity.CategoryEntity;
import eu.busi.projetPizza.dataAcces.util.IngredientConveter;
import eu.busi.projetPizza.dataAcces.util.PizzaConveter;
import eu.busi.projetPizza.dataAcces.util.generator.NameGenerator;
import eu.busi.projetPizza.model.Constants;
import eu.busi.projetPizza.model.Ingredient;
import eu.busi.projetPizza.model.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/pizza")
@SessionAttributes({Constants.CURRENT_USER, Constants.CURRENT_PIZZA, Constants.CURRENT_PIZZA, Constants.CURRENT_PIZZA_Custom, Constants.CURRENT_MY_MAP_PIZZA})
public class PizzaController {

    private final PizzaDAO pizzaDAO;
    private final CategoryDAO categorieDAO;
    private final IngredientDAO ingredientDAO;
    private static float PRICE_OF_INGREDIENTS = 3;

    public PizzaController(PizzaDAO pizzaDAO, CategoryDAO categorieDAO, IngredientDAO ingredientDAO) {
        this.pizzaDAO = pizzaDAO;
        this.categorieDAO = categorieDAO;
        this.ingredientDAO = ingredientDAO;
    }

   @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)
    public Map<Long, Pizza> pizzaMap() {return new HashMap<>();}


    @RequestMapping(method = RequestMethod.GET)
    public String pizza(Model model) {

        model.addAttribute("categories", categorieDAO.getListCategories());
        model.addAttribute("pizzas", pizzaDAO.listPizza());
        model.addAttribute("ingredients", ingredientDAO.getAllIngredients());
        return "integrated:pizza";
    }


    @RequestMapping(value = "/trieCategorieByName/{id}", method = RequestMethod.GET)
    public String triCategoryByName(@PathVariable(value = "id") String name, Model model) {
        CategoryEntity categoryEntity = categorieDAO.getCategoriyEntityByName(name);
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

    @RequestMapping(value = "/ajouterAuPanier", method = RequestMethod.POST)
    public String lookPizzasAndAddinCart(Model model, @Valid @ModelAttribute(Constants.CURRENT_PIZZA) Pizza infospizza, final BindingResult errors, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)Map<Long, Pizza> pizzaHashMap) {

        Pizza pizza = pizzaDAO.findPizzaById(infospizza.getId());
        Pizza pizza1 = pizzaHashMap.get(pizza.getId());
        if (pizzaHashMap.get(pizza.getId()) != null) {
            pizza.setNumber(pizza1.getNumber() + infospizza.getNumber());
        } else {
            pizza.setNumber(infospizza.getNumber());
        }

        if (errors.hasErrors()) {
            return "redirect:/pizza";
        }
        pizzaHashMap.put(infospizza.getId(), pizza);
        return "redirect:/pizza";
    }


    @RequestMapping(value = "/ajouterAuPanierPizzaCustom", method = RequestMethod.POST)
        public String lookPizzaCustomsAndAddinCart(@ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA) Map < Long, Pizza > pizzaHashMap, @RequestParam("ingredients") List < Integer > integerList, @ModelAttribute(Constants.CURRENT_PIZZA_Custom) Pizza
        infospizza,final BindingResult result){
            List<Ingredient> ingredientList = new ArrayList<>();
            Pizza pizza = new Pizza();

            for (int item : integerList) {
                Ingredient ingredient = ingredientDAO.loadIngredientById(item);
                if (ingredientDAO.checkIfStockQuantiteAndgetStock_Quantity_IngredientIsNull(IngredientConveter.ingredientIngredientToIngredientEntity(ingredient))) {
                    PRICE_OF_INGREDIENTS += ingredient.getUnit_price();
                    ingredientList.add(ingredient);
                }
            }
            if (!ingredientList.isEmpty()) {
                Pizza pizzaCustom = getPizza(ingredientList, pizza);
                pizzaHashMap.put(pizzaCustom.getId(), pizzaCustom);
            }

            if (result.hasErrors()) {
                return "integrated:pizza";
            }
            return "redirect:/pizza";
        }

        private Pizza getPizza (List < Ingredient > ingredientList, Pizza pizza){
            pizza.setName(NameGenerator.generateName());
            pizza.setFixed(false);
            pizza.setIngredients(ingredientList);
            pizza.setPrice(PRICE_OF_INGREDIENTS);
            pizza.setNumber(1);
            pizza.setCategory(categorieDAO.getCategoriyByName("normal"));
            return pizzaDAO.savePizza(PizzaConveter.pizzaModelTopizzaEntity(pizza));
        }
}