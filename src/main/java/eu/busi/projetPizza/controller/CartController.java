package eu.busi.projetPizza.controller;

import eu.busi.projetPizza.dataAcces.dao.OderDAO;
import eu.busi.projetPizza.dataAcces.dao.Oder_LineDAO;
import eu.busi.projetPizza.dataAcces.dao.UserDAO;
import eu.busi.projetPizza.dataAcces.service.OderLineSaveService;
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
@SessionAttributes({Constants.CURRENT_USER,Constants.CURRENT_PIZZA, Constants.CURRENT_MY_MAP_PIZZA })
public class CartController extends HttpServlet {

    Map<Long, Pizza> pizzaHashMap = new HashMap<Long, Pizza>();

    @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)
    public Map<Long, Pizza> pizzaMap() {
        return pizzaHashMap;
    }

    @ModelAttribute(Constants.PIZZA_EDIT)
    public Pizza pizza() {        return new Pizza();    }

    @Autowired
    public OderDAO oderDAO;

    @Autowired
    public UserDAO userDAO;

    @Autowired
    public Oder_LineDAO oder_lineDAO;

    @Autowired
    public OderLineSaveService oderLineSaveService;


    @RequestMapping(method = RequestMethod.GET)
    public String Cart(Model model, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)Map<Long, Pizza> pizzaMapCart)
    {
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

      /*  *//**To Delete**//*
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

        session.setAttribute("ListPanier", pizzaList);*/
        /**End of Delete**/

        model.addAttribute("Total", total);
        model.addAttribute("SubTotal", subtotal);
        model.addAttribute("Shipping", delivery_price);
        model.addAttribute("ContentCart", pizzaList);
        return "integrated:cart";
    }

    @PostMapping(value = "/sendAdd")
    public String AddNumberPizzaToCart(Model model,@RequestParam("id") long id, @ModelAttribute(Constants.PIZZA_EDIT) Pizza pizza, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)Map<Long, Pizza> pizzaMapCart) {

        Pizza newPizza = pizzaMapCart.get(id);
        newPizza.setNumber(newPizza.getNumber() + 1);
        pizzaMapCart.replace(id, newPizza);

        return "redirect:/cart";
    }

    @PostMapping(value = "/sendSubstract")
    public String SubstractNumberPizzaToCart(Model model,@RequestParam("id") long id, @ModelAttribute(Constants.PIZZA_EDIT) Pizza pizza, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)Map<Long, Pizza> pizzaMapCart) {

        Pizza newPizza = pizzaMapCart.get(id);
        if(newPizza.getNumber() <= 1){pizzaMapCart.remove(id, newPizza);}
        else{newPizza.setNumber(newPizza.getNumber() - 1);
            pizzaMapCart.replace(id, newPizza);        }
        return "redirect:/cart";
    }

    @PostMapping(value = "/sendDelete")
    public String DeletePizzaToCart(Model model,@RequestParam("id") long id, @ModelAttribute(Constants.PIZZA_EDIT) Pizza pizza, @ModelAttribute(Constants.CURRENT_MY_MAP_PIZZA)Map<Long, Pizza> pizzaMapCart) {

        Pizza newPizza = pizzaMapCart.get(id);
        pizzaMapCart.remove(id, newPizza);

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

