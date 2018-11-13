package eu.busi.projetPizza.controller;

import eu.busi.projetPizza.dataAcces.dao.OderDAO;
import eu.busi.projetPizza.dataAcces.service.OderService;
import eu.busi.projetPizza.enums.StatusEnum;
import eu.busi.projetPizza.model.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_USER,Constants.CURRENT_PIZZA, Constants.CURRENT_MY_MAP_PIZZA })
public class CartController extends HttpServlet {

    Map<Long, Pizza> pizzaMap = new HashMap<Long, Pizza>();

    @ModelAttribute(Constants.PIZZA_EDIT)
    public Pizza pizza() {
        return new Pizza();
    }

    @Autowired
    public OderDAO oderDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String Cart(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("title", "Cart");

        HttpSession session = request.getSession();
        float total = 0;
        LocalDateTime a = LocalDateTime.now();

        /**To Delete**/
        List<Pizza> pizzaList = new ArrayList<>();
        Pizza pizza1 = new Pizza();
        pizza1.setName("hotdog");
        pizza1.setPrice(6);
        pizza1.setId(1);
        Category category = new Category();
        Category category1 = new Category();
        category.setId(1);
        category.setName("india");
        pizza1.setNumber(1);

        Pizza pizza2 = new Pizza();
        pizza2.setName("hamburger");
        pizza2.setPrice(10);
        pizza2.setId(2);
        category1.setName("USA");
        pizza2.setNumber(2);
        pizzaList.add(pizza1);
        pizzaList.add(pizza2);

        Oder oder = new Oder();

        Promo promo = new Promo();
        promo.setName("ola");
        promo.setId(5L);
        promo.setReduction(0.5f);

        oder.setDate_order(a);
        oder.setDelivery_price(0);
        oder.setFull_price(25);
        oder.setIs_paid(true);
        oder.setTotal_price(25);
        oder.setStatusEnum(StatusEnum.IN_PROGRESS);

        oder.setUser(null);

        session.setAttribute("ListPanier", pizzaList);
        /**End of Delete**/


        HttpSession getPizzaSession;
        getPizzaSession = request.getSession(false);
        List<Pizza> pizzaPanierList = (List<Pizza>) getPizzaSession.getAttribute("ListPanier");

        /**Loop to set the amount of the order*/

        for (Iterator<Pizza> i = pizzaPanierList.iterator(); i.hasNext(); ) {
            Pizza item = i.next();
            total += (item.getPrice() * item.getNumber());
        }

        /**Add delivery price if the amount of the order is less than 15 euros**/

        if (total <= 15) {
            total += 5;
        }
        model.addAttribute("Total", total);
        session.setAttribute("TotalToPaid", total);
        model.addAttribute("ContentCart", pizzaList);

        return "integrated:cart";
    }

    @PostMapping(value = "/sendAdd")
    public String AddNumberPizzaToCart(Model model, HttpServletRequest request, @RequestParam("id") long id, @ModelAttribute(Constants.PIZZA_EDIT) Pizza pizza) {
        //HttpSession session = request.getSession();
        // float total = (float) session.getAttribute("TotalToPaid");
        HttpSession getPanierSession = request.getSession(false);
        List<Pizza> listPizza = (List<Pizza>) getPanierSession.getAttribute("ListPanier");


        for (Iterator<Pizza> i = listPizza.iterator(); i.hasNext(); ) {
            Pizza item = i.next();
            pizzaMap.put(item.getId(), item);
        }
        Pizza newPizza = pizzaMap.get(id);
        newPizza.setNumber(newPizza.getNumber() + 1);
        pizzaMap.replace(id, newPizza);


        // listPizza.set(id, pizza.setNumber((pizza.getNumber() + 1));

        /*Optional<Pizza> pizzaToGetPrice = listPizza
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst();
        total += pizzaToGetPrice.get().getPrice();
        session.setAttribute("TotalToPaid", total);*/
        return "redirect:/cart";
    }
}

