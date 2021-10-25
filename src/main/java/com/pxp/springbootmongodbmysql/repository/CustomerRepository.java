package com.pxp.springbootmongodbmysql.repository;

import com.pxp.springbootmongodbmysql.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    public boolean existsByEmail(String email);

    public List<Customer> findByEmail(String email);

    public void deleteByEmail(String email);
}
