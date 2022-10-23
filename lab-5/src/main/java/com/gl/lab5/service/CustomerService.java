package com.gl.lab5.service;

import java.util.List;

import com.gl.lab5.entity.Customer;

/**
 * @author svraja
 *
 */
public interface CustomerService {

	public List<Customer> fetchAll();

	public void save(Customer theCustomer);

	public Customer findById(int theId);

	public Customer DeleteById(int theId);

}
