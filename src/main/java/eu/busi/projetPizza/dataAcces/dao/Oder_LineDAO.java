package eu.busi.projetPizza.dataAcces.dao;




import eu.busi.projetPizza.dataAcces.entity.OrderLineEntity;
import eu.busi.projetPizza.dataAcces.repository.OrderLineRepository;

import eu.busi.projetPizza.dataAcces.util.OderLineConverter;

import eu.busi.projetPizza.model.Order_Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class Oder_LineDAO {

    @Autowired
    private final OrderLineRepository orderLineRepository;

    public Oder_LineDAO(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public Order_Line save(Order_Line order_line) {
        OrderLineEntity orderLineEntity = OderLineConverter.oder_lineModelToOderrEntity(order_line);
        orderLineEntity = orderLineRepository.save(orderLineEntity);
        return OderLineConverter.order_lineEntityToOderModel(orderLineEntity);
    }
}