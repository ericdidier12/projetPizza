package eu.busi.projetPizza.dataAcces.dao;



import eu.busi.projetPizza.dataAcces.entity.OderEntity;
import eu.busi.projetPizza.dataAcces.repository.OrderRepository;
import eu.busi.projetPizza.dataAcces.util.OderConverter;
import eu.busi.projetPizza.model.Oder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class OderDAO {

    @Autowired
    private final OrderRepository orderRepository;

    public OderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Oder save(Oder oder) {
        OderEntity oderEntity = OderConverter.oderModelToOderrEntity(oder);
        oderEntity = orderRepository.save(oderEntity);
        return OderConverter.oderEntityToOderModel(oderEntity);
    }
    public Oder loadOrderById(long Id) {
        OderEntity oderEntity = orderRepository.findOne(Id);
        return OderConverter.oderEntityToOderModel(oderEntity);
    }
}