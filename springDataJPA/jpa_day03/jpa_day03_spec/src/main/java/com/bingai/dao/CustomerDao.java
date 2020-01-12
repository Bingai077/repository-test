package com.bingai.dao;

import com.bingai.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CustomerDao extends JpaRepository<Customer,Long>,JpaSpecificationExecutor<Customer> {




}

