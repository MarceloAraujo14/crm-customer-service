package br.com.crmcustomer.dataprovider;

import br.com.crmcustomer.dataprovider.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterCustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
}
