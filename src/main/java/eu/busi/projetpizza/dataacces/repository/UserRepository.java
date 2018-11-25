package eu.busi.projetpizza.dataacces.repository;

import eu.busi.projetpizza.dataacces.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity,Long> {
   UserEntity findByUsername(String userName);
}
