package com.pxp.springbootmongodbmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pxp.springbootmongodbmysql.entity.Creditcard;


@Repository
public interface CreditCardRepository extends JpaRepository<Creditcard, String> {

}
