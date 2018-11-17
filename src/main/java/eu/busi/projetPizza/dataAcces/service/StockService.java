package eu.busi.projetPizza.dataAcces.service;

import eu.busi.projetPizza.dataAcces.dao.IngredientDAO;
import eu.busi.projetPizza.dataAcces.dao.OderDAO;
import eu.busi.projetPizza.dataAcces.entity.IngredientEntity;
import eu.busi.projetPizza.enums.StatusEnum;
import eu.busi.projetPizza.model.Ingredient;
import eu.busi.projetPizza.model.Oder;
import eu.busi.projetPizza.model.Pizza;
import eu.busi.projetPizza.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class StockService {
    @Autowired
    private IngredientDAO ingredientDAO;

    public boolean booleanTestPizzaInStock(List<Pizza> pizzaList) {

        boolean test = true;
        Collection<Ingredient> ingredientList = new ArrayList<>();
        Map<Long, Ingredient> ingredientMap = new HashMap<Long, Ingredient>();
        Ingredient ingredientTemp;
        for (Pizza item : pizzaList) {
            for (Ingredient ingredient : item.getIngredients()) {
                if (ingredientMap.get(ingredient.getId()) != null) {
                    ingredientTemp = ingredientMap.get(ingredient.getId());
                    ingredientTemp.setNumberIngredient(ingredientTemp.getNumberIngredient() + (1 * item.getNumber()));
                    ingredientMap.replace(ingredientTemp.getId(), ingredientTemp);
                } else {
                    ingredient.setNumberIngredient(1 * item.getNumber());
                    ingredientMap.put(ingredient.getId(), ingredient);
                }
            }

        }
        ingredientList = ingredientMap.values();
        for (Ingredient item : ingredientList)
        {
            if ((item.getNumberIngredient() * item.getRecipe_qunatity()) > item.getStock_quantity())
            {
                test = false;
                break;
            }
        }
        for(Ingredient item : ingredientList)
        {
            item.setStock_quantity(item.getStock_quantity()-(item.getNumberIngredient() * item.getRecipe_qunatity()));
            IngredientEntity ingredientEntity = ingredientDAO.saveUpdateIngredient(item);
        }
        return test;
    }

}
