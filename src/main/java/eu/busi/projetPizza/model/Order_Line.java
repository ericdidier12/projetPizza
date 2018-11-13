
package eu.busi.projetPizza.model;


import java.util.List;

public class Order_Line {

    private long id;
    private Pizza pizza;
    private int quantite;


    private List<Pizza> pizzaList;
    private List<Oder> oderList;

    public Order_Line() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public List<Oder> getOderList() {
        return oderList;
    }

    public void setOderList(List<Oder> oderList) {
        this.oderList = oderList;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }


    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}

