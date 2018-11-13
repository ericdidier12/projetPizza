package eu.busi.projetPizza.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * created by  eric.nyandwi on Nov,13/11/2018
 */
public class Panier {

    private Map<Long, Order_Line> items = new HashMap<Long, Order_Line>();

    public void addItem(Pizza p, int quantite) {
        Order_Line lc = items.get(p.getId());
        if (lc == null) {
            Order_Line art = new Order_Line();
            art.setPizza(p);
            art.setQuantite(quantite);
            //art.setPizza(p);
            items.put(p.getId(), art);
        } else {
            lc.setQuantite(lc.getQuantite() + quantite);
        }
    }

    public Collection<Order_Line> getItems() {
        return items.values();
    }

    public int getSize() {
        return items.size();
    }

    public double getTotal() {
        double total = 0;
        for (Order_Line lc : items.values()) {
            total += lc.getPizza().getPrice() * lc.getQuantite();
        }
        return total;
    }

    public void deleteItem(Long idproduit) {
        items.remove(idproduit);
    }
}
