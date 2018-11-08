
package eu.busi.projetPizza.model;

import eu.busi.projetPizza.dataAcces.entity.Authority;


import java.util.List;

public class Pizza {

    private int id;
    private String name;
    private float price;
    private boolean month_promo;
    private boolean fixed;

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Pizza(String name, float price, boolean month_promo, boolean fixed, List<Category> categoryList) {
        this.name = name;
        this.price = price;
        this.month_promo = month_promo;
        this.fixed = fixed;
        this.categoryList = categoryList;
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

    public Pizza() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

