package com.agnila.customer.dal.repo;

import org.springframework.data.repository.CrudRepository;

import com.agnila.customer.dal.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long > {

}
