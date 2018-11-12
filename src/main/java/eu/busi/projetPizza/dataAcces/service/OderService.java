package eu.busi.projetPizza.dataAcces.service;

import eu.busi.projetPizza.dataAcces.dao.OderDAO;
import eu.busi.projetPizza.enums.StatusEnum;
import eu.busi.projetPizza.model.Oder;
import eu.busi.projetPizza.model.Promo;
import eu.busi.projetPizza.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OderService {
    private OderDAO oderDAO;

    public void InsertOder(Oder oder)
    {
    oderDAO.save(oder);
    }
    public Oder CreateOrder()
    {
        Oder oder = new Oder();
        LocalDateTime a = LocalDateTime.now();
        User user = new  User();
        oder.setDate_order(a);
        oder.setDelivery_price(0);
        oder.setFull_price(25);
        oder.setIs_paid(true);
        oder.setTotal_price(25);
        oder.setStatusEnum(StatusEnum.IN_PROGRESS);

        //oder.setPromos(Promo);
        return oder;
    }
}
