package eu.busi.projetPizza.configuration;

import eu.busi.projetPizza.dataAcces.entity.Authority;
import eu.busi.projetPizza.dataAcces.entity.UserEntity;
import eu.busi.projetPizza.dataAcces.repository.AuthorityRepository;
import eu.busi.projetPizza.dataAcces.repository.UserRepository;
import eu.busi.projetPizza.dataAcces.util.UserConverter;
import eu.busi.projetPizza.enums.RoleEnum;
import eu.busi.projetPizza.model.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * <p>
 * Initializes & Creating a user and the role attribute (s)
 * </p>
 *
 * @author Eric Nyandwi
 */
@Component
public class DbInit implements InitializingBean {

 /*   private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private final PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }*/

    @Override
    public void afterPropertiesSet() throws Exception {

        /*
        // Creating a user and the role attribute(s)
        */

     /*   Authority authority =new Authority();
        authority.setAuthority(RoleEnum.ADMIN.getValue());

        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setEmail("amdin@hotmail.com");

        switch (authority.getAuthority()) {
            case "ROLE_USER":
                user.setAuthorities(new ArrayList<>(Collections.singletonList(createOrGetAuthority(RoleEnum.USER.getValue()))));
                break;
            case "ROLE_ADMIN":
                user.setAuthorities(new ArrayList<>());
                user.getAuthorities().add(createOrGetAuthority(RoleEnum.ADMIN.getValue()));
                break;
        }

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        UserEntity userEntity = userRepository.save(UserConverter.userModelToUserEntity(user));
        user = UserConverter.userEntityToUserModel(userEntity);
        System.out.println(" Utilisateur Ajouté dans la base de donnée est :"
                + userRepository.findByUsername(user.getUsername()).getUsername()
                +"  son mot de passe  :" + userRepository.findByUsername(user.getUsername()).getPassword());


    }

    public Authority createOrGetAuthority(String authority) {

        Authority found = authorityRepository.findByAuthority(authority);

        if (found == null) {
            found = new Authority(authority);
            authorityRepository.save(found);
        }

        return found;*/
    }
}

