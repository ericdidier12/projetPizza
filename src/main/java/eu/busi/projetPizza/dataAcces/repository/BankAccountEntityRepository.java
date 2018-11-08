package eu.busi.projetPizza.dataAcces.repository;

import eu.busi.projetPizza.dataAcces.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  eric.nyandwi on Nov,08/11/2018
 */

public interface BankAccountEntityRepository  extends JpaRepository<BankAccountEntity,Long> {
}
