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

