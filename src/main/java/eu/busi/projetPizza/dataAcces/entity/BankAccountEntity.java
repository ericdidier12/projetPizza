package eu.busi.projetPizza.dataAcces.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

/**
 * created by  eric.nyandwi on Nov,08/11/2018
 */
@Entity
@Table(name = "bank_account")
public class BankAccountEntity extends BaseEntity{

    private String iban ;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "user_entity_id", referencedColumnName = "id")
    private UserEntity userEntity ;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
