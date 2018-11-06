package eu.busi.projetPizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

/**
 * SecurityAutoConfiguration.class  permet de Desactive le congfig par defaut de Loging par defaut.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PizzaApplication {



    public static void main(String[] args) {
        SpringApplication.run(PizzaApplication.class, args);
    }


}
