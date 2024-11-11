package com.ra.repository;

import com.ra.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Kiểm tra tồn tại email
    Boolean existsCustomerByEmail(String email);
}
