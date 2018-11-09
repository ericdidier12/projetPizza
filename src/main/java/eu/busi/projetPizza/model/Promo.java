package eu.busi.projetPizza.model;

import eu.busi.projetPizza.dataAcces.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * created by  eric.nyandwi on Nov,08/11/2018
 */
public class Promo  {

    private Long id;
    private String name;
    private float reduction ;

    public Promo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
