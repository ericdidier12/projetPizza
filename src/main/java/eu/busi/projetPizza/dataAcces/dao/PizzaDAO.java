
package eu.busi.projetPizza.dataAcces.dao;

import eu.busi.projetPizza.dataAcces.entity.CategoryEntity;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.dataAcces.repository.PizzaRepository;

import eu.busi.projetPizza.dataAcces.util.PizzaConveter;

import eu.busi.projetPizza.model.Pizza;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class PizzaDAO {

    private final PizzaRepository pizzaRepository;

    public PizzaDAO(PizzaRepository pizzaRepository) {

        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> loadAllPizza() {
        List<PizzaEntity> pizzaEntitieslist = pizzaRepository.findAll();
        return pizzaEntitieslist;
    }

    public PizzaEntity loadPizzaById(long Id) {
        PizzaEntity pizzaEntities = pizzaRepository.findOne(Id);
        return pizzaEntities;
    }

    public Pizza savePizza(PizzaEntity pizzaEntity) {
        PizzaEntity pizzaEntitySave = pizzaRepository.save(pizzaEntity);
        return PizzaConveter.pizzaEntityTopizzaModel(pizzaEntitySave);
    }

    public List<Pizza> listPizza() {
        List<PizzaEntity> pizzaEntities = pizzaRepository.findAll();
        List<Pizza> pizzas = new ArrayList<>();

        for (PizzaEntity pizzaEntity : pizzaEntities) {
            pizzas.add(PizzaConveter.pizzaEntityTopizzaModel(pizzaEntity));
        }
        return pizzas;
    }


    public List<Pizza> findByCategoryEntity(CategoryEntity category) {
        List<Pizza> pizzas = new ArrayList<>();
        List<PizzaEntity> pizzaEntities = pizzaRepository.findByCategoryEntity(category);

        pizzas = pizzaEntities.stream().
                map(pizzaEntity -> PizzaConveter.pizzaEntityTopizzaModel(pizzaEntity)).collect(Collectors.toList());
        return pizzas;
    }

    public Pizza getPizzaById(Long idPizza) {
        PizzaEntity pizzaEntity = pizzaRepository.getPizzaEntityById(idPizza);
        return PizzaConveter.pizzaEntityTopizzaModel(pizzaEntity);
    }

    public  Pizza findPizzaById(Long id){
        PizzaEntity pizzaEntity= pizzaRepository.findOne(id);
        return PizzaConveter.pizzaEntityTopizzaModel(pizzaEntity);
    }


}
