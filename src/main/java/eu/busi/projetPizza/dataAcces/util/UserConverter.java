package eu.busi.projetPizza.dataAcces.util;

import eu.busi.projetPizza.dataAcces.entity.UserEntity;
import eu.busi.projetPizza.model.User;

import java.util.List;

/**
 * TODO "Il faut complementer certains champs manquante consulter diagramme de classe .. ou votre colaborateur "
 * Transformation entre le modèle des entités JPA et les objetsModel .
 * <br/>
 */
public class UserConverter {



    /**
     * Transforme une entité JPA {@link UserEntity} en objet TDO {@link User}.
     * @param userEntity
     * @return Objet type User
     */
    public static User userEntityToUserModel(UserEntity userEntity){
        if (userEntity == null) {
            throw new IllegalArgumentException(" objet userEntity  ne peut pas être null ");
        }
        User user = new User();

        user.setUsername(userEntity.getUsername() != null ? userEntity.getUsername() : null);
        user.setEmail(userEntity.getEmail() != null ? userEntity.getEmail() : null);
        user.setPassword(userEntity.getPassword());
        user.setAccountNonExpired(userEntity.isAccountNonExpired());
        //user.setAccountNonLocked(userEntity.isAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.isCredentialsNonExpired());
        user.setEnabled(userEntity.isEnabled());

        user.setAuthorities(userEntity.getAuthorities() !=null ? userEntity.getAuthorities()  : null);
        return  user;
    }



    /**
     * Transforme un objet TDO {@link User} en une entité JPA {@link UserEntity}.
     * @param user
     * @return objet artist
     */
    public static UserEntity UserModelToUserEntity (User user){
        if (user == null) {
            throw new IllegalArgumentException(" objet userEntity  ne peut pas être null ");
        }
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(user.getUsername() != null ? user.getUsername() : null);
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail() != null ? user.getEmail() : null);
        userEntity.setAccountNonExpired(user.isAccountNonExpired());
        userEntity.setAccountNonLocked(user.isAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userEntity.setEnabled(user.isEnabled());

        userEntity.setAuthorities(user.getAuthorities() !=null ? user.getAuthorities()  : null);
        return  userEntity;
    }

}
