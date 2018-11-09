
package eu.busi.projetPizza.dataAcces.repository;

import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.dataAcces.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PizzaRepository extends JpaRepository<PizzaEntity,Long> {

  // PizzaEntity findByPizzaId(Long id);
}

