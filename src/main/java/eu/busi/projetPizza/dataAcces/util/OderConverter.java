package eu.busi.projetPizza.dataAcces.util;

import eu.busi.projetPizza.dataAcces.entity.OderEntity;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.dataAcces.entity.PromoEntity;
import eu.busi.projetPizza.dataAcces.entity.UserEntity;
import eu.busi.projetPizza.enums.StatusEnum;
import eu.busi.projetPizza.model.Oder;
import eu.busi.projetPizza.model.Pizza;
import eu.busi.projetPizza.model.Promo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Transformation entre le modèle des entités JPA et les objetsModel .
 * created by  eric.nyandwi on Nov,08/11/2018
 */
public class OderConverter {

    /**
     * Transforme une entité JPA {@link eu.busi.projetPizza.dataAcces.entity.OderEntity} en objet Model {@link eu.busi.projetPizza.model.Oder}.
     * @param oderEntity
     * @return Objet type Oder
     */
    public static Oder oderEntityToOderModel(OderEntity oderEntity){
        if (oderEntity == null) {
            throw new IllegalArgumentException(" objet oderEntity  ne peut pas être null ");
        }
        Oder oder = new Oder();
        oder.setId(oderEntity.getId());
        oder.setDate_order(oderEntity.getDate_order());
        oder.setDelivery_price(oderEntity.getDelivery_price());
        oder.setFull_price(oderEntity.getFull_price());
        oder.setIs_paid(oderEntity.isIs_paid());
        oder.setStatusEnum(oderEntity.getStatusEnum());
        oder.setTotal_price(oderEntity.getTotal_price());
        Collection<Promo> promos  = new ArrayList<>();
        if (oderEntity.getPromoEntity() != null ){
            for (PromoEntity promo: oderEntity.getPromoEntity()) {
                promos.add(PromoConverter.promoEntityToPromoModel(promo));
            }
            oder.setPromos(promos);
        }
        oder.setUser(UserConverter.userEntityToUserModel(oderEntity.getUserEntity()));
        return  oder;
    }

    /**
     * Transforme un objet Model {@link Oder} en une entité JPA {@link OderEntity}.
     * @param oder
     * @return objet OderEntity
     */
    public static OderEntity oderModelToOderrEntity (Oder oder) {
        if (oder == null) {
            throw new IllegalArgumentException(" objet oder  ne peut pas être null ");
        }
        OderEntity oderEntity = new OderEntity();
        oderEntity.setId(oder.getId());
        oderEntity.setDate_order(oder.getDate_order());
        oderEntity.setDelivery_price(oder.getDelivery_price());
        oderEntity.setFull_price(oder.getFull_price());
        oderEntity.setIs_paid(oder.isIs_paid());
        oderEntity.setStatusEnum(oder.getStatusEnum());
        oderEntity.setUserEntity(UserConverter.userModelToUserEntity(oder.getUser()));
        oderEntity.setTotal_price(oder.getTotal_price());

        Collection<PromoEntity> promoEntity  = new ArrayList<>();
        if (oder.getPromos() != null ){
            for (Promo promo: oder.getPromos()) {
                promoEntity.add(PromoConverter.promoModelToPromoEntity(promo));
            }
            oderEntity.setPromoEntity(promoEntity);
        }


        oderEntity.setUserEntity(UserConverter.userModelToUserEntity(oder.getUser()));


        return oderEntity;
    }

}
