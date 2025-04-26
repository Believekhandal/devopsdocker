package com.believe.portfolio.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.believe.portfolio.entity.Customer;

public interface UserRepository extends JpaRepository<Customer, Long> {
    // Custom queries if needed
}
