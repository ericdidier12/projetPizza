package eu.busi.projetPizza.dataAcces.repository;

import eu.busi.projetPizza.dataAcces.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  eric.nyandwi on Nov,12/11/2018
 */
public interface IngredientRepository  extends JpaRepository<IngredientEntity, Long> {
}
