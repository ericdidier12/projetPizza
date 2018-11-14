package eu.busi.projetPizza.dataAcces.dao;

import eu.busi.projetPizza.dataAcces.entity.CategoryEntity;
import eu.busi.projetPizza.dataAcces.repository.CategorieRepository;
import eu.busi.projetPizza.dataAcces.util.CategorieConveter;
import eu.busi.projetPizza.model.Category;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * created by  eric.nyandwi on Nov,12/11/2018
 */

@Service
@Transactional
public class CategorieDAO {

    private final CategorieRepository categorieRepository;

    public CategorieDAO(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Category> getListCategories() {
        List<CategoryEntity> categoryEntities = categorieRepository.findAll();
        List<Category> categories = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            categories.add(CategorieConveter.CategoryEntityToCategoryModel(categoryEntity));
        }
        return categories;
    }

    public CategoryEntity getCategoriyByName(String name){
        return  categorieRepository.findByName(name);
    }
}