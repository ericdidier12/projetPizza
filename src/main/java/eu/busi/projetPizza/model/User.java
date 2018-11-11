package eu.busi.projetPizza.model;


import eu.busi.projetPizza.dataAcces.entity.Authority;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class User {

    @NotNull
    @Size(min = 3, max = 30, message = "Your name must between 6 and 15 characters")
    private String name;

    @NotNull
    @Size(min = 3, max = 15, message = "Your username must between 6 and 15 characters")
    private String username;

    @NotNull
    //@Size(min = 3, max = 15, message = "Your password must between 3 and 15 characters")
    private String password;

    @NotNull
    @NotEmpty(message = "Please enter your email addresss.")
    @Email
    private String email;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled ;
    private List<Authority> authorities;
    private LocalDate birth_date;

    @Size(min=4, max=50)
    private String adress;


    private Collection<BankAccount> bankAccountEntities;
    private Collection<Oder> oders;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public Collection<BankAccount> getBankAccountEntities() {
        return bankAccountEntities;
    }

    public void setBankAccountEntities(Collection<BankAccount> bankAccountEntities) {
        this.bankAccountEntities = bankAccountEntities;
    }

    public Collection<Oder> getOders() {
        return oders;
    }

    public void setOders(Collection<Oder> oders) {
        this.oders = oders;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
