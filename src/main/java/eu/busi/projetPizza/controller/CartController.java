package eu.busi.projetPizza.controller;

import eu.busi.projetPizza.dataAcces.dao.OderDAO;
import eu.busi.projetPizza.dataAcces.dao.Oder_LineDAO;
import eu.busi.projetPizza.dataAcces.dao.UserDAO;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.dataAcces.repository.OrderLineRepository;
import eu.busi.projetPizza.dataAcces.repository.OrderRepository;
import eu.busi.projetPizza.dataAcces.service.OderLineSaveService;
import eu.busi.projetPizza.dataAcces.service.OderService;
import eu.busi.projetPizza.enums.StatusEnum;
import eu.busi.projetPizza.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;

import static eu.busi.projetPizza.model.Constants.CURRENT_USER;

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

    @Autowired
    public UserDAO userDAO;

    @Autowired
    public Oder_LineDAO oder_lineDAO;

    @Autowired
    public OderLineSaveService oderLineSaveService;


    @RequestMapping(method = RequestMethod.GET)
    public String Cart(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("title", "Cart");

        HttpSession session = request.getSession();
        float total = 0;
        float totalWithoutDelivery = 0;
        LocalDateTime a = LocalDateTime.now();

        /**To Delete**/
        Category category = new Category();
        Category category1 = new Category();
        category.setId(1);
        category.setName("normal");
        category1.setId(2);
        category1.setName("american");

        List<Pizza> pizzaList = new ArrayList<>();
        Pizza pizza1 = new Pizza();
        Pizza pizza2 = new Pizza();

        pizza1.setName("hotdog");
        pizza1.setPrice(6);
        pizza1.setId(1);
        pizza1.setNumber(1);
        pizza1.setCategory(category);
        pizza1.setFixed(true);


        pizza2.setName("hamburger");
        pizza2.setPrice(10);
        pizza2.setId(2);
        pizza2.setNumber(2);
        pizza2.setCategory(category1);
        pizza2.setFixed(true);

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
            totalWithoutDelivery += (item.getPrice() * item.getNumber());
        }

        /**Add delivery price if the amount of the order is less than 15 euros**/
        total = totalWithoutDelivery;
        if (total <= 15) {
            totalWithoutDelivery += 5;
        }
        model.addAttribute("Total", totalWithoutDelivery);
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

    @PostMapping(value = "/valider")
    public String createOrder(Model model, HttpServletRequest request, @ModelAttribute(Constants.PIZZA_EDIT) Pizza pizza, Principal principal) {
        HttpSession getPanierSession = request.getSession();
        List<Pizza> listPizza = (List<Pizza>) getPanierSession.getAttribute("ListPanier");
        Float total = (Float) getPanierSession.getAttribute("TotalToPaid");


        Promo promo = new Promo();
        promo.setId(2L);

        Oder oder = new Oder();
         String nom =  principal.getName();
         User user1 = userDAO.findByUsername(nom);
        oder.setUser(user1);
        oder.setTotal_price(oder.getFull_price() + oder.getDelivery_price());
        oder.setStatusEnum(StatusEnum.IN_PROGRESS);
        oder.setIs_paid(false);
        oder.setDate_order(LocalDateTime.now());

        if (total <= 15) {
            oder.setDelivery_price(5);
        } else {
            oder.setDelivery_price(0);
        }
        if(promo != null){oder.setFull_price(total-((total/100)*promo.getReduction()));}
        else{oder.setFull_price(total);}
/**Enlever les comment pour ajouter un commande au panier**/
        Oder oder1 = oderDAO.save(oder);


/**Test of save order_Line to DB**/

        Order_Line order_line = new Order_Line();
        order_line.setOder(oder1);
        order_line.setPizzaList(listPizza);

        oderLineSaveService.InsertListOrderLine(order_line);
        //oder_lineDAO.save(order_line);

        return "redirect:/home";

    }

}

