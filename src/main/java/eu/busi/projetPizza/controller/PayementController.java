package eu.busi.projetPizza.controller;

import eu.busi.projetPizza.dataAcces.dao.OderDAO;
import eu.busi.projetPizza.dataAcces.dao.Oder_LineDAO;
import eu.busi.projetPizza.dataAcces.dao.UserDAO;
import eu.busi.projetPizza.dataAcces.service.OderLineSaveService;
import eu.busi.projetPizza.model.Constants;
import eu.busi.projetPizza.model.Oder;
import eu.busi.projetPizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping(value = "/payement")
@SessionAttributes({Constants.CURRENT_TOTAL, Constants.ORDER_ID})
public class PayementController {

    @Autowired
    private OderDAO oderDAO;

   @RequestMapping(method = RequestMethod.GET)
    public String Payement(Model model, @ModelAttribute(Constants.CURRENT_TOTAL) float total, @ModelAttribute(Constants.ORDER_ID) int IdOrder ){
        model.addAttribute("title", "Payement");

        model.addAttribute("order_ID", IdOrder);
        model.addAttribute("total", total);

        return "integrated:payement";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/setorderpaid")
    public String SetOrderPaid(Model model, @ModelAttribute(Constants.ORDER_ID) int IdOrder)
    {
        Oder oder = oderDAO.loadOrderById(IdOrder);
        oder.setIs_paid(true);
        Oder oder1 = oderDAO.save(oder);
        return "redirect:/home";
    }
}










/*
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
*//**Enlever les comment pour ajouter un commande au panier**//*
        Oder oder1 = oderDAO.save(oder);


*//**Test of save order_Line to DB**//*

        Order_Line order_line = new Order_Line();
        order_line.setOder(oder1);
        order_line.setPizzaList(listPizza);

        oderLineSaveService.InsertListOrderLine(order_line);
        //oder_lineDAO.save(order_line);

        return "redirect:/home";

    }*/



