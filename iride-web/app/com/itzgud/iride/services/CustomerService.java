package com.itzgud.iride.services;

import java.util.List;

import com.itzgud.iride.dto.mongo.CustomerDto;

public interface CustomerService {
	
	CustomerDto getCustomer(int customerId);
	List<CustomerDto> getAllCustomers();
	void deleteCustomer(String customerId);
	void saveCustomer(CustomerDto customerDto);
	
}
