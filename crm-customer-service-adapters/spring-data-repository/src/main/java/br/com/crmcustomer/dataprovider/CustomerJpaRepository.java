package br.com.crmcustomer.dataprovider;

import br.com.crmcustomer.dataprovider.entity.CustomerToPersist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerToPersist, String> {
}
