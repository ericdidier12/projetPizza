package eu.busi.projetPizza.dataAcces.entity;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    private Set<PizzaEntity> pizzaEntities;

    public CategoryEntity() {
    }

    public Set<PizzaEntity> getPizzaEntities() {
        return pizzaEntities;
    }
}
