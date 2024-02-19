package org.dnyanyog.service;

import java.util.List;

import org.dnyanyog.dto.AddCustomerResponse;
import org.dnyanyog.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface SearchCustomerService {

	public AddCustomerResponse getSingleCustomer(Long customer_id);
	
	public List<Customer> getAllCustomers();
	
	public List<Long> getAllCustomerIds();
}
