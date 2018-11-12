
package eu.busi.projetPizza.dataAcces.util;


import eu.busi.projetPizza.dataAcces.entity.IngredientEntity;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.model.Category;
import eu.busi.projetPizza.model.Ingredient;
import eu.busi.projetPizza.model.Pizza;

import java.util.List;


public class IngredientConverter {


    public static Ingredient ingredientEntityToUserModel(IngredientEntity ingredientEntity) {
        if (ingredientEntity == null) {
            throw new IllegalArgumentException("  ");
        }
        Ingredient ingredient = new Ingredient();

        ingredient.setName(ingredientEntity.getName());
        ingredient.setRecipe_qunatity(ingredientEntity.getRecipe_quantity());
        ingredient.setStock_quantity(ingredientEntity.getStock_quantity());
        ingredient.setUnit_price(ingredientEntity.getUnit_price());

        return ingredient;
    }

    public static IngredientEntity IngredientModelToIngredientEntity(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException(" objet pizzaEntity  ne peut pas être null ");
        }
        IngredientEntity ingredientEntity = new IngredientEntity();

        ingredientEntity.setName(ingredient.getName());
        ingredientEntity.setRecipe_quantity(ingredient.getRecipe_qunatity());
        ingredientEntity.setStock_quantity(ingredient.getStock_quantity());
        ingredientEntity.setUnit_price(ingredient.getUnit_price());

        return ingredientEntity;
    }

}

