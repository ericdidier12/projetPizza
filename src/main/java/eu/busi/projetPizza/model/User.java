package eu.busi.projetPizza.model;

import eu.busi.projetPizza.dataAcces.entity.AdressEntity;
import eu.busi.projetPizza.dataAcces.entity.Authority;
import eu.busi.projetPizza.dataAcces.entity.BankAccountEntity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class User {

    private String username;
    private String password;
    private String email;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean enabled ;
    public List<Authority> authorities;
    private LocalDate birth_date;
    private Collection<BankAccountEntity> bankAccountEntities;
    private AdressEntity adressEntity ;
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

    public Collection<BankAccountEntity> getBankAccountEntities() {
        return bankAccountEntities;
    }

    public void setBankAccountEntities(Collection<BankAccountEntity> bankAccountEntities) {
        this.bankAccountEntities = bankAccountEntities;
    }

    public AdressEntity getAdressEntity() {
        return adressEntity;
    }

    public void setAdressEntity(AdressEntity adressEntity) {
        this.adressEntity = adressEntity;
    }

    public Collection<Oder> getOders() {
        return oders;
    }

    public void setOders(Collection<Oder> oders) {
        this.oders = oders;
    }
}
