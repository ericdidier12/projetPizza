
package eu.busi.projetpizza.dataacces.repository;

import eu.busi.projetpizza.dataacces.entity.CategoryEntity;
import eu.busi.projetpizza.dataacces.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PizzaRepository extends JpaRepository<PizzaEntity,Long> {
    List<PizzaEntity> findByCategoryEntity(CategoryEntity categoryEntity);
}

