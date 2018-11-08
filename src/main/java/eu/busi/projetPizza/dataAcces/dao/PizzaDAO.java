
package eu.busi.projetPizza.dataAcces.dao;

import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.dataAcces.repository.PizzaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Primary
@Service
@Transactional
public class PizzaDAO {

    private final PizzaRepository pizzaRepository;

    public PizzaDAO(PizzaRepository pizzaRepository) {

        this.pizzaRepository = pizzaRepository;
    }

   public List<PizzaEntity> loadAllPizza()
   {
       List<PizzaEntity> pizzaEntitieslist = pizzaRepository.findAll();
       return pizzaEntitieslist;
   }

   public PizzaEntity loadPizzaById(long Id)
   {
       PizzaEntity pizzaEntities = pizzaRepository.findOne(Id);
       return pizzaEntities;
   }


}
