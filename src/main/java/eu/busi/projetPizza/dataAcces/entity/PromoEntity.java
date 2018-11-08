package eu.busi.projetPizza.dataAcces.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * PromoEntity est la classe représentant le promo d'un
 * created by  eric.nyandwi on Nov,08/11/2018
 */

@Entity
@Table(name = "promo_code")
public class PromoEntity extends  BaseEntity {

    private String name;
    private BigDecimal reduction ;

    public PromoEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public void setReduction(BigDecimal reduction) {
        this.reduction = reduction;
    }
}
