package org.dnyanyog.service;

import java.util.List;

import org.dnyanyog.dto.AddCustomerRequest;
import org.dnyanyog.dto.AddCustomerResponse;
import org.dnyanyog.entity.Customer;
import org.dnyanyog.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCustomerServiceImpl implements AddCustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	AddCustomerResponse customerResponse;

	@Override
	public AddCustomerResponse addCustomer(AddCustomerRequest customerRequest) {

		Customer customerTable = Customer.getInstance()
				.setUsername(customerRequest.getUsername())
				.setPassword(customerRequest.getPassword()).setAge(customerRequest.getAge())
				.setEmail(customerRequest.getEmail());

		customerTable = customerRepo.save(customerTable);

		customerResponse.setStatus("Success");
		customerResponse.setMessage("Customer Added Successfully");
		customerResponse.setCustomer_id(customerTable.getCustomerId());
		customerResponse.getCustomerData().setUsername(customerTable.getUsername());
		customerResponse.getCustomerData().setPassword(customerTable.getPassword());
		customerResponse.getCustomerData().setAge(customerTable.getAge());
		customerResponse.getCustomerData().setEmail(customerTable.getEmail());

		return customerResponse;
	}
}
