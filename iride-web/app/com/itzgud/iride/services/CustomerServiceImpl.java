package com.itzgud.iride.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itzgud.iride.dao.CustomerDao;
import com.itzgud.iride.dto.mongo.CustomerDto;
import com.itzgud.iride.entities.mongo.Customer;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CustomerDto.Mapper dtoMapper;

	@Override
	public CustomerDto getCustomer(int customerId) {
		Customer customer = customerDao.findById(customerId);
		return dtoMapper.fromEntity(customer);
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers= customerDao.findAll();
		return dtoMapper.fromEntities(customers);
	}

	@Override
	public void deleteCustomer(String customerId) {
		customerDao.deleteCustomer(customerId);
		
	}

	@Override
	public void saveCustomer(CustomerDto customerDto) {
		customerDao.createCustomer(dtoMapper.newEntity(customerDto));
		
	}
	
	
	
	
	
}
