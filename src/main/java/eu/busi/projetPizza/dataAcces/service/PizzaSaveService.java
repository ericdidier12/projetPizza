package eu.busi.projetPizza.dataAcces.service;

import eu.busi.projetPizza.dataAcces.dao.PizzaDAO;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.dataAcces.util.PizzaConveter;
import eu.busi.projetPizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaSaveService {

    @Autowired
    private PizzaDAO pizzaDAO;

    public void InsertNewPizza(Pizza pizza) {
        PizzaEntity pizzaEntity = PizzaConveter.pizzaModelTopizzaEntity(pizza);
        Pizza pizza1 = pizzaDAO.savePizza(pizzaEntity);
        }
    }

