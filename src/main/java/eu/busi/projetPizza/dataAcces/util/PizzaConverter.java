
package eu.busi.projetPizza.dataAcces.util;


import eu.busi.projetPizza.dataAcces.entity.IngredientEntity;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.dataAcces.entity.UserEntity;

import eu.busi.projetPizza.model.Category;
import eu.busi.projetPizza.model.Ingredient;
import eu.busi.projetPizza.model.Pizza;
import eu.busi.projetPizza.model.User;

import java.util.ArrayList;
import java.util.List;


public class PizzaConverter {


    public static Pizza pizzaEntityToUserModel(PizzaEntity pizzaEntity) {
        if (pizzaEntity == null) {
            throw new IllegalArgumentException("  ");
        }
        Pizza pizza = new Pizza();

        pizza.setName(pizzaEntity.getName());
        pizza.setFixed(pizzaEntity.isFixed());
        pizza.setMonth_promo(pizzaEntity.isMonth_promo());
        pizza.setPrice(pizzaEntity.getPrice());

        pizza.setCategory(CategorieConveter.CategoryEntityToCategoryModel(pizzaEntity.getCategoryEntity()));
        List<Ingredient> ingredients = new ArrayList<>();
        if(pizzaEntity.getIngredientEntityList() != null) {
            for (IngredientEntity ingredientEntity :pizzaEntity.getIngredientEntityList()) {
                ingredients.add(IngredientConveter.ingredientIngredientTopizzaModel(ingredientEntity));
            }
            pizza.setIngredients(ingredients);
        }

        return pizza;
    }

    public static PizzaEntity PizzaModelToPizzaEntity(Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException(" objet pizzaEntity  ne peut pas être null ");
        }
        PizzaEntity pizzaEntity = new PizzaEntity();

        pizzaEntity.setFixed(pizza.isFixed());
        pizzaEntity.setMonth_promo(pizza.isMonth_promo());
        pizzaEntity.setName(pizza.getName());
        pizzaEntity.setPrice(pizza.getPrice());

        List<IngredientEntity> ingredientEntity  = new ArrayList<>();
        if (pizza.getIngredients() != null ) {
            for (Ingredient ingredient1 : pizza.getIngredients()) {
                ingredientEntity.add(IngredientConveter.ingredientIngredientTopizzaModel(ingredient1));
            }
            pizzaEntity.setIngredientEntityList(ingredientEntity);
        }

        if(pizza.getCategory() != null) {
            pizzaEntity.setCategoryEntity(CategorieConveter.CategoryModelToCategoryEntity(pizza.getCategory()));
        }

        return pizzaEntity;
    }

}

