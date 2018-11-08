package eu.busi.projetPizza.dataAcces.util;


import eu.busi.projetPizza.dataAcces.entity.BankAccountEntity;
import eu.busi.projetPizza.dataAcces.entity.UserEntity;
import eu.busi.projetPizza.model.BankAccount;
import eu.busi.projetPizza.model.User;

/**
 * <b>
 * Transformation entre le modèle des entités JPA et les objetsModel .
 * </b>
 * <br/>
 * created by  eric.nyandwi on Nov,08/11/2018
 */
public class BankAccountConverter {

    /**
     * Transforme une entité JPA {@link UserEntity} en objet Model {@link User}.
     * @param bankAccountEntity
     * @return
     */
    public static BankAccount BankAccountEntityToBankAccountModel(BankAccountEntity bankAccountEntity) {
        if (bankAccountEntity == null) {
            throw new IllegalArgumentException(" objet BankAccountEntity  ne peut pas être null ");
        }
        BankAccount bankAccount = new BankAccount();
        bankAccount.setIban(bankAccount.getIban() != null ? bankAccount.getIban() : null);
        bankAccount.setUser(UserConverter.userEntityToUserModel(bankAccountEntity.getUserEntity() != null ?
                            bankAccountEntity.getUserEntity() : null));
        return bankAccount;
    }


    /**
     * Transforme un objet Model {@link BankAccount} en une entité JPA {@link BankAccountEntity}.
     *
     * @param bankAccount
     * @return objet type bankAccountEntity
     */
    public static BankAccountEntity  bankAccountModelBankAccountEntity(BankAccount bankAccount) {
        if (bankAccount == null) {
            throw new IllegalArgumentException(" objet BankAccount  ne peut pas être null ");
        }
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setIban(bankAccount.getIban() != null ? bankAccount.getIban() : null);
        bankAccountEntity.setUserEntity(UserConverter.userModelToUserEntity(bankAccount.getUser()));
        return bankAccountEntity;
    }
}
