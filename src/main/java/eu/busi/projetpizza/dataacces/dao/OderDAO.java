package eu.busi.projetpizza.dataacces.dao;



import eu.busi.projetpizza.dataacces.entity.OderEntity;
import eu.busi.projetpizza.dataacces.repository.OrderRepository;
import eu.busi.projetpizza.dataacces.util.OderConverter;
import eu.busi.projetpizza.model.Oder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class OderDAO {

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