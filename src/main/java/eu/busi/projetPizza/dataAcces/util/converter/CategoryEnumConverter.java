package eu.busi.projetPizza.dataAcces.util.converter;

import eu.busi.projetPizza.enums.CategoryEnum;
import eu.busi.projetPizza.enums.EnumUtils;
import eu.busi.projetPizza.enums.StatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class CategoryEnumConverter implements AttributeConverter<CategoryEnum, Integer> {


    @Override
    public Integer convertToDatabaseColumn(CategoryEnum categoryEnum) {
        return categoryEnum != null ? categoryEnum.getValue() : null;
    }

    @Override
     public CategoryEnum convertToEntityAttribute(Integer dbData) {
        return dbData != null ? EnumUtils.findEnumByValue(CategoryEnum.class, dbData) : null;
    }
}
