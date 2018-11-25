package eu.busi.projetpizza.dataacces.repository;

import eu.busi.projetpizza.dataacces.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrderLineRepository extends JpaRepository<OrderLineEntity,Long> {}