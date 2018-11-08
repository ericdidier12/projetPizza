package eu.busi.projetPizza.model;

/**
 * created by  eric.nyandwi on Nov,08/11/2018
 */
public class BankAccount {

    private String iban ;
    private User user ;

    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
