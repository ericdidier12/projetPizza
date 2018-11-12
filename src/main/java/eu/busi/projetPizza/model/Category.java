
package eu.busi.projetPizza.model;


import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;

import java.util.HashSet;
import java.util.Set;

public class Category {

    private long id;
    private String name;
    private Set<Pizza> pizzas;

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Set<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}

