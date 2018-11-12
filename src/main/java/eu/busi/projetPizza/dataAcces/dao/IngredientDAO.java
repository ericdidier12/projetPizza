package eu.busi.projetPizza.dataAcces.dao;

import eu.busi.projetPizza.dataAcces.entity.IngredientEntity;
import eu.busi.projetPizza.dataAcces.repository.IngredientRepository;
import eu.busi.projetPizza.dataAcces.util.IngredientConveter;
import eu.busi.projetPizza.model.Ingredient;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * created by  eric.nyandwi on Nov,12/11/2018
 */
@Service
@Transactional
public class IngredientDAO {

    private  final IngredientRepository ingredientRepository ;

    public IngredientDAO(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

   public IngredientEntity saveIngredient(Ingredient ingredient) {
        return  ingredientRepository.save(IngredientConveter.IngredientIngredientTopizzaModel(ingredient)) ;
    }
}
