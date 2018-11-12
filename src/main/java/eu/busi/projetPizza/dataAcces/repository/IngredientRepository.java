
package eu.busi.projetPizza.dataAcces.repository;

import eu.busi.projetPizza.dataAcces.entity.IngredientEntity;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IngredientRepository extends JpaRepository<IngredientEntity,Long> {

  // PizzaEntity findByPizzaId(Long id);
}

