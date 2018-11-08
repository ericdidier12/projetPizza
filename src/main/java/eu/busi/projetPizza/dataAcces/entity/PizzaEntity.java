package eu.busi.projetPizza.dataAcces.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pizza")
public class PizzaEntity extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private float price;
    @Column(name = "month_promo")
    private boolean  month_promo;
    @Column(name = "fixed")
    private boolean fixed;



    public PizzaEntity() {
    }

    public PizzaEntity(String name, float price, boolean month_promo, boolean fixed, CategoryEntity categoryEntity, List<IngredientEntity> ingredientEntityList) {
        this.name = name;
        this.price = price;
        this.month_promo = month_promo;
        this.fixed = fixed;
        this.categoryEntity = categoryEntity;
        this.ingredientEntityList = ingredientEntityList;
    }

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private CategoryEntity categoryEntity;

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }


    @ManyToMany(mappedBy = "pizzaEntitiesList")
    private List<IngredientEntity> ingredientEntityList;

    public List<IngredientEntity> getIngredientEntityList() {
        return ingredientEntityList;
    }

    public void setIngredientEntityList(List<IngredientEntity> ingredientEntityList) {
        this.ingredientEntityList = ingredientEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isMonth_promo() {
        return month_promo;
    }

    public void setMonth_promo(boolean month_promo) {
        this.month_promo = month_promo;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}
