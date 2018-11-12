
package eu.busi.projetPizza.model;


import java.util.List;

public class Order_Line {

    private long id;
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
}

