package eu.busi.projetpizza.dataacces.repository;

import eu.busi.projetpizza.dataacces.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByAuthority(String authority);
}
