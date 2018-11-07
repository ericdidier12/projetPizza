package eu.busi.projetPizza.dataAcces.dao;

import eu.busi.projetPizza.dataAcces.entity.UserEntity;
import eu.busi.projetPizza.dataAcces.repository.UserRepository;
import eu.busi.projetPizza.enums.RoleEnum;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Primary
@Service
@Transactional
public class UserDAO implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity found = userRepository.findByUsername(username);

        if (found == null) {
            throw new UsernameNotFoundException("Username not found"); // Exception il est fourni par Spring
        }

        System.out.println("Login OKAY");
        return found;
    }


}
