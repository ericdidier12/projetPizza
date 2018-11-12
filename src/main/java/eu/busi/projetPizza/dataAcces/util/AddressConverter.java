package eu.busi.projetPizza.dataAcces.util;

import eu.busi.projetPizza.dataAcces.entity.AdressEntity;
import eu.busi.projetPizza.model.Adress;

/**
 * Transformation entre le modèle des entités JPA et les objetsModel .
 * created by  eric.nyandwi on Nov,09/11/2018
 */
public class AddressConverter {

    /**
     * Transforme une entité JPA {@link AdressEntity} en objet Model {@link Adress}.
     * @param adressEntity
     * @return Objet type adress
     */
    public static Adress AdressEntityToadressModel(AdressEntity adressEntity){
        if (adressEntity == null) {
            throw new IllegalArgumentException(" objet adressEntity  ne peut pas être null ");
        }

        Adress adress = new Adress();
        adress.setBox(adressEntity.getBox());
        adress.setCountry(adressEntity.getCountry());
        adress.setNumber(adressEntity.getNumber());
        adress.setStreet(adressEntity.getStreet());
        adress.setZip_code(adressEntity.getZip_code());

        return  adress;
    }

    /**
     * Transforme un objet Model {@link Adress} en une entité JPA {@link AdressEntity}.
     * @param adress
     * @return objet AdressEntity
     */
    public static AdressEntity adressModelToAdressEntity (Adress adress) {
        if (adress == null) {
            throw new IllegalArgumentException(" objet oder  ne peut pas être null ");
        }
        AdressEntity adressEntity = new AdressEntity();
        adressEntity.setBox(adress.getBox());
        adressEntity.setCountry(adress.getCountry());
        adressEntity.setNumber(adress.getNumber());
        adressEntity.setStreet(adress.getStreet());
        adressEntity.setZip_code(adress.getZip_code());
        return adressEntity;
    }
}
