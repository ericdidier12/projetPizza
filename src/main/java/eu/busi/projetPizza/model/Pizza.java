
package eu.busi.projetPizza.model;

import eu.busi.projetPizza.enums.CategoryEnum;


import java.util.List;

public class Pizza {

    private long id;
    private String name;
    private float price;
    private boolean month_promo;
    private boolean fixed;
    private List<Order_Line> order_line;
    private int number = 1;
    private Category category;
    private List<Ingredient> ingredients;

    public Pizza() {
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Order_Line> getOrder_line() {
        return order_line;
    }

    public void setOrder_line(List<Order_Line> order_line) {
        this.order_line = order_line;
    }

    public Category getCategory(){
        return category;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

