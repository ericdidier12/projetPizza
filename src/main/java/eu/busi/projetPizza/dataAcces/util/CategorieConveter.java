package eu.busi.projetPizza.dataAcces.util;

import eu.busi.projetPizza.dataAcces.entity.CategoryEntity;
import eu.busi.projetPizza.dataAcces.entity.PizzaEntity;
import eu.busi.projetPizza.model.Category;
import eu.busi.projetPizza.model.Pizza;

import java.util.Set;

/**
 * created by  eric.nyandwi on Nov,12/11/2018
 */
public class CategorieConveter {

    /**
     * Transforme une entité JPA {@link CategoryEntity} en objet Model {@link Category}.
     *
     * @param categoryEntity
     * @return Objet type Category
     */
    public static Category CategoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            throw new IllegalArgumentException(" objet categoryEntity  ne peut pas être null ");
        }

        Category category = new Category();
        category.setName(categoryEntity.getName());
        return category;
    }

/**
 * Transforme une entité JPA {@link CategoryEntity} en objet Model {@link Category}.
 * @param category
 * @return
 */
    public static CategoryEntity CategoryModelToCategoryEntity(Category category) {
        if (category == null) {
            throw new IllegalArgumentException(" objet Category  ne peut pas être null ");
        }

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        return categoryEntity ;
    }



}