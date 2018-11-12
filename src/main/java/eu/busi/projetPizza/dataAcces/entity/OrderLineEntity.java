package eu.busi.projetPizza.dataAcces.entity;


import eu.busi.projetPizza.model.Oder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "order_line")
public class OrderLineEntity extends BaseEntity {

    @Column(name = "number_of_pizza")
    private int number_of_pizza;

/*****PizzaEntity******/

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private PizzaEntity pizzaOrderLineEntity;

    /*****IngredientEntity******/

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OderEntity oderOrderLineEntity;




    public OrderLineEntity() {
    }

    public int getNumber_of_pizza() {
        return number_of_pizza;
    }

    public void setNumber_of_pizza(int number_of_pizza) {
        this.number_of_pizza = number_of_pizza;
    }

    public PizzaEntity getPizzaOrderLineEntity() {
        return pizzaOrderLineEntity;
    }

    public void setPizzaOrderLineEntity(PizzaEntity pizzaOrderLineEntity) {
        this.pizzaOrderLineEntity = pizzaOrderLineEntity;
    }

    public OderEntity getOderOrderLineEntity() {
        return oderOrderLineEntity;
    }

    public void setOderOrderLineEntity(OderEntity oderOrderLineEntity) {
        this.oderOrderLineEntity = oderOrderLineEntity;
    }
}
