package eu.busi.projetPizza.dataAcces.repository;

import eu.busi.projetPizza.dataAcces.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  eric.nyandwi on Nov,12/11/2018
 */
public interface CategorieRepository  extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByName(String namCategory);

}
