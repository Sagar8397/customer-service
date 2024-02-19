package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.AddCustomerResponse;
import org.dnyanyog.entity.Customer;
import org.dnyanyog.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchCustomerServiceImpl implements SearchCustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	AddCustomerResponse customerResponse;

	@Autowired
	Customer customer;

	@Override
	public AddCustomerResponse getSingleCustomer(Long customer_id) {

		Optional<Customer> receivedData = customerRepo.findById(customer_id);

		if (receivedData.isPresent()) {
			Customer customer = receivedData.get();
			customerResponse.setStatus("Success");
			customerResponse.setMessage("Customer Found Successfully");
			customerResponse.setCustomer_id(customer_id);
			customerResponse.getCustomerData().setUsername(customer.getUsername());
			customerResponse.getCustomerData().setAge(customer.getAge());
			customerResponse.getCustomerData().setEmail(customer.getEmail());
		} else {
			customerResponse.setStatus("unsuccess");
			customerResponse.setMessage("Customer not found");
		}
		return customerResponse;
	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerRepo.findByAllCustomer();
	}

	@Override
	public List<Long> getAllCustomerIds() {

		return customerRepo.findByIdOfAllCustomer();
	}
}
