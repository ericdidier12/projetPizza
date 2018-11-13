package eu.busi.projetPizza.dataAcces.repository;

import eu.busi.projetPizza.dataAcces.entity.OderEntity;
import eu.busi.projetPizza.dataAcces.entity.OrderLineEntity;
import eu.busi.projetPizza.model.Order_Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrderLineRepository extends JpaRepository<OrderLineEntity,Long> {

    // PizzaEntity findByPizzaId(Long id);
    //  @Query("INSERT Oder ")


}