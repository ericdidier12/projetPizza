package eu.busi.projetPizza.dataAcces.dao;

import eu.busi.projetPizza.dataAcces.entity.IngredientEntity;
import eu.busi.projetPizza.dataAcces.util.IngredientConveter;
import eu.busi.projetPizza.dataAcces.repository.IngredientRepository;


import eu.busi.projetPizza.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class IngredientDAO {

    private final IngredientRepository ingredientRepository;

    public IngredientDAO(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public IngredientEntity saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(IngredientConveter.ingredientIngredientTopizzaModel(ingredient));
    }

    public List<IngredientEntity> loadAllIngredient() {
        List<IngredientEntity> ingredientEntitiesList = ingredientRepository.findAll();
        return ingredientEntitiesList;
    }

    public IngredientEntity loadIngredientEntityById(long Id) {
        IngredientEntity ingredientEntity = ingredientRepository.findOne(Id);
        return ingredientEntity;
    }
    public Ingredient loadIngredientById(long Id)
    {

        IngredientEntity ingredientEntity = ingredientRepository.findOne(Id);
        Ingredient ingredient = IngredientConveter.ingredientIngredientTopizzaModel(ingredientEntity);
        return ingredient;
    }

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        List<IngredientEntity> ingredientEntities = ingredientRepository.findAll();
        ingredients = ingredientEntities.stream()
                .map(ingredientEntity ->
                        IngredientConveter.ingredientIngredientTopizzaModel(ingredientEntity))
                .collect(Collectors.toList());
        return ingredients;
    }

}
