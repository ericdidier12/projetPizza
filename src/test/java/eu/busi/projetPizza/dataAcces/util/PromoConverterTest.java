package eu.busi.projetPizza.dataAcces.util;

import eu.busi.projetPizza.dataAcces.entity.PromoEntity;
import eu.busi.projetPizza.model.Promo;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * created by  eric.nyandwi on Nov,08/11/2018
 */
public class PromoConverterTest {

    public static final  String NAME = "Summer";
    public  static final BigDecimal REDUCTION_PROMO =  new BigDecimal("5.34");

    @Test(expected = IllegalArgumentException.class)
    public void TestpromoEntityNullToPromoModel () {
        PromoConverter.promoModelToPromoEntity(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void userModelNULLToUserEntity () {
        PromoConverter.promoEntityToPromoModel(null);
    }

    @Test
    public void toPromoEntity() {
         PromoEntity promoEntity = new PromoEntity();
         promoEntity.setId(2l);
         promoEntity.setName(NAME);
         promoEntity.setReduction(REDUCTION_PROMO);
        Promo promoModel = PromoConverter.promoEntityToPromoModel(promoEntity);

        assertEquals(promoModel.getName(),promoModel.getName());
        assertEquals( REDUCTION_PROMO,promoModel.getReduction());
    }

    @Test
    public void toPromoModel() {
        Promo promoModel = new Promo();
        promoModel.setId(2l);
        promoModel.setName(NAME);
        promoModel.setReduction(REDUCTION_PROMO);
        PromoEntity promoEntity = PromoConverter.promoModelToPromoEntity(promoModel);

        assertEquals(NAME, promoEntity.getName());
        assertEquals( REDUCTION_PROMO, promoEntity.getReduction());
    }


}