package eu.busi.projetPizza.dataAcces.dao;


import eu.busi.projetPizza.dataAcces.entity.UserEntity;
import eu.busi.projetPizza.dataAcces.repository.AuthorityRepository;
import eu.busi.projetPizza.dataAcces.repository.UserRepository;

import eu.busi.projetPizza.dataAcces.util.UserConverter;
import eu.busi.projetPizza.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.stereotype.Service;

import javax.transaction.Transactional;



@Primary
@Service
@Transactional
public class UserDAO implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public UserDAO(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    public User saveUser(User userInt) {
        UserEntity userEntity = UserConverter.userModelToUserEntity(userInt);
        return UserConverter.userEntityToUserModel( userRepository.save(userEntity));

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

    public User findByUsername(String name){
         return UserConverter.userEntityToUserModel(userRepository.findByUsername(name));

    }

    public Boolean IsExist( User user){
        boolean isExist = false;
        UserEntity userEntity = userRepository.findByUsername(user.getUsername());
        if(userEntity != null){
            isExist = true;
        }
        return isExist;
    }

}
