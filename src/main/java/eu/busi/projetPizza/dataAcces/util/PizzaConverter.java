
package eu.busi.projetPizza.dataAcces.util;

import eu.busi.projetPizza.dataAcces.entity.CategoryEntity;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.dataAcces.entity.UserEntity;

import eu.busi.projetPizza.model.Category;
import eu.busi.projetPizza.model.Pizza;
import eu.busi.projetPizza.model.User;

import java.util.List;


public class PizzaConverter {


    public static Pizza pizzaEntityToUserModel(PizzaEntity pizzaEntity){
        if (pizzaEntity == null) {
            throw new IllegalArgumentException("  ");
        }
        Pizza pizza = new Pizza();

        pizza.setName(pizzaEntity.getName());
        pizza.setFixed(pizzaEntity.isFixed());
        pizza.setMonth_promo(pizzaEntity.isMonth_promo());
        pizza.setPrice(pizzaEntity.getPrice());
        pizza.setCategoryList((List<Category>) pizzaEntity.getCategoryEntity());

        return  pizza;
    }


    public static PizzaEntity PizzaModelToPizzaEntity (Pizza pizza){
        if (pizza == null) {
            throw new IllegalArgumentException(" objet pizzaEntity  ne peut pas être null ");
        }
        PizzaEntity pizzaEntity = new PizzaEntity();

        pizzaEntity.setFixed(pizza.isFixed());
        pizzaEntity.setMonth_promo(pizza.isMonth_promo());
        pizzaEntity.setName(pizza.getName());
        pizzaEntity.setPrice(pizza.getPrice());
        pizzaEntity.setCategoryEntity((CategoryEntity) pizza.getCategoryList());


        return  pizzaEntity;
    }

}

