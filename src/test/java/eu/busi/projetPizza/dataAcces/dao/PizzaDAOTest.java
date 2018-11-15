package eu.busi.projetPizza.dataAcces.dao;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;

/**
 * created by  eric.nyandwi on Nov,15/11/2018
 */
public class PizzaDAOTest {

    @Mock
    private IngredientDAO ingredientDAO;

    @InjectMocks
    private PizzaDAO pizzaDAO;

}