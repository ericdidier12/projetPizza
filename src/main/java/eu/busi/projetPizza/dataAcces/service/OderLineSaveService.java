package eu.busi.projetPizza.dataAcces.service;


import eu.busi.projetPizza.dataAcces.dao.Oder_LineDAO;
import eu.busi.projetPizza.model.Oder;
import eu.busi.projetPizza.model.Order_Line;
import eu.busi.projetPizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OderLineSaveService {
    @Autowired
    private Oder_LineDAO oder_lineDAO;

    public void InsertListOrderLine(Order_Line order_line) {
        List<Pizza> pizzas = order_line.getPizzaList();
        Oder oder = order_line.getOder();

        for (Pizza pizza : pizzas) {
            Order_Line order_line1 = new Order_Line();
            order_line1.setPizza(pizza);
            order_line1.setOder(oder);
            order_line1.setNumber(pizza.getNumber());

            Order_Line order_line2 = oder_lineDAO.save(order_line1);
        }
    }
}
