
package eu.busi.projetPizza.dataAcces.repository;

import eu.busi.projetPizza.dataAcces.entity.CategoryEntity;
import eu.busi.projetPizza.dataAcces.entity.IngredientEntity;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.dataAcces.entity.UserEntity;
import eu.busi.projetPizza.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PizzaRepository extends JpaRepository<PizzaEntity,Long> {
    List<PizzaEntity> findByCategoryEntity(CategoryEntity categoryEntity);
    PizzaEntity getPizzaEntityById(Long idPizza);


}

