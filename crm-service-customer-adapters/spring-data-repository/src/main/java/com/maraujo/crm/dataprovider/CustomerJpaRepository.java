package com.maraujo.crm.dataprovider;

import com.maraujo.crm.dataprovider.entity.CustomerToPersist;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Primary
public interface CustomerJpaRepository extends JpaRepository<CustomerToPersist, String> {
}
