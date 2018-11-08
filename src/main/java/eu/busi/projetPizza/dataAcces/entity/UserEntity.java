package eu.busi.projetPizza.dataAcces.entity;

import eu.busi.projetPizza.dataAcces.util.converter.LocalDateTimeAttributeConverter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "user_client")
public class UserEntity extends BaseEntity implements UserDetails {

    @Basic
    @Column(nullable = false)
    private String email;

    @Basic
    @Column(nullable = false, unique = true, length = 23)
    private String username;

    @Basic
    @Column(nullable = false)
    private String password;


    @Column(nullable = true)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDate birth_date;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private Collection<BankAccountEntity> bankAccountEntities;

    @Column(name = "ACOUNT_NOT_LOCKED")
    private boolean accountNonLocked;

    @Column(name = "ACOUNT_NOT_EXPIRED")
    private boolean accountNonExpired;

    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private boolean credentialsNonExpired;

    @Column(name = "ENABLED")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER) // EAGER c-à-d à chaque fois vous charge user vous chargerai aussi se Role
    @Fetch(value = FetchMode.SUBSELECT)
    public List<Authority> authorities;

    @Embedded
    private AdressEntity adressEntity;

    @OneToMany(mappedBy="userEntity", cascade = CascadeType.ALL)
    private Collection<OderEntity> oderEntities;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public List<Authority> getAuthorities() {
        return authorities;
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

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public Collection<OderEntity> getOderEntities() {
        return oderEntities;
    }

    public void setOderEntities(Collection<OderEntity> oderEntities) {
        this.oderEntities = oderEntities;
    }
}
