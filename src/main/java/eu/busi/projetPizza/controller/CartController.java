package eu.busi.projetPizza.controller;

import eu.busi.projetPizza.dataAcces.dao.OderDAO;
import eu.busi.projetPizza.dataAcces.dao.Oder_LineDAO;
import eu.busi.projetPizza.dataAcces.dao.UserDAO;
import eu.busi.projetPizza.dataAcces.service.CheckoutCartService;
import eu.busi.projetPizza.dataAcces.service.OderLineSaveService;
import eu.busi.projetPizza.dataAcces.util.CustomException;
import eu.busi.projetPizza.enums.StatusEnum;
import eu.busi.projetPizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_USER, Constants.CURRENT_PIZZA, Constants.CURRENT_MY_MAP_PIZZA, Constants.CURRENT_TOTAL, Constants.ORDER_ID})
public class CartController {

    Map<Long, Pizza> pizzaHashMap = new HashMap<Long, Pizza>();

    @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)
    public Map<Long, Pizza> pizzaMap() {
        return pizzaHashMap;
    }

    @ModelAttribute(Constants.PIZZA_EDIT)
    public Pizza pizza() {
        return new Pizza();
    }

    @Autowired
    public OderDAO oderDAO;

    @Autowired
    public UserDAO userDAO;

    @Autowired
    public Oder_LineDAO oder_lineDAO;

    @Autowired
    public OderLineSaveService oderLineSaveService;

    @Autowired
    public CheckoutCartService checkoutCartService;


    @RequestMapping(method = RequestMethod.GET)
    public String Cart(Model model, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA) Map<Long, Pizza> pizzaMapCart) {
        model.addAttribute("title", "Cart");
        Collection<Pizza> pizzaList = pizzaMapCart.values();
        float total = 0;
        float subtotal = 0;
        float delivery_price = 0;
        LocalDateTime a = LocalDateTime.now();

        for (Iterator<Pizza> i = pizzaList.iterator(); i.hasNext(); ) {
            Pizza item = i.next();
            subtotal += (item.getPrice() * item.getNumber());
        }
        if (subtotal <= 15) {
            delivery_price = 5;
        }
        total = delivery_price + subtotal;

        model.addAttribute("Total", total);
        model.addAttribute("SubTotal", subtotal);
        model.addAttribute("Shipping", delivery_price);
        model.addAttribute("ContentCart", pizzaList);

        return "integrated:cart";
    }

    @PostMapping(value = "/sendAdd")
    public String AddNumberPizzaToCart(Model model, @RequestParam("id") long id, @ModelAttribute(Constants.PIZZA_EDIT) Pizza pizza, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA) Map<Long, Pizza> pizzaMapCart) {

        Pizza newPizza = pizzaMapCart.get(id);
        newPizza.setNumber(newPizza.getNumber() + 1);
        pizzaMapCart.replace(id, newPizza);

        return "redirect:/cart";
    }

    @PostMapping(value = "/sendSubstract")
    public String SubstractNumberPizzaToCart(Model model, @RequestParam("id") long id, @ModelAttribute(Constants.PIZZA_EDIT) Pizza pizza, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA) Map<Long, Pizza> pizzaMapCart) {

        Pizza newPizza = pizzaMapCart.get(id);
        if (newPizza.getNumber() <= 1) {
            pizzaMapCart.remove(id, newPizza);
        } else {
            newPizza.setNumber(newPizza.getNumber() - 1);
            pizzaMapCart.replace(id, newPizza);
        }
        return "redirect:/cart";
    }

    @PostMapping(value = "/sendDelete")
    public String DeletePizzaToCart(Model model, @RequestParam("id") long id, @ModelAttribute(Constants.PIZZA_EDIT) Pizza pizza, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA) Map<Long, Pizza> pizzaMapCart) {

        Pizza newPizza = pizzaMapCart.get(id);
        pizzaMapCart.remove(id, newPizza);

        return "redirect:/cart";
    }

    @PostMapping(value = "/valider")
    public String createOrder(Model model, @ModelAttribute(Constants.PIZZA_EDIT) Pizza pizza, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA) Map<Long, Pizza> pizzaMapCart, Principal principal) {
        try {
            if (pizzaMapCart.isEmpty()) {
                throw new CustomException("No Pizzas found in your cart");
            }
            checkoutCartService.CreateCompleteOrder(pizza, pizzaMapCart, principal.getName());
            model.addAttribute("total", checkoutCartService.getTotal());
            model.addAttribute("IdOrder", checkoutCartService.getIdOrder());
            return "redirect:/payement";
        } catch (CustomException ex) {
            return "redirect:/error";
        }
    }
}


