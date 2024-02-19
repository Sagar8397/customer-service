package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.AddCustomerRequest;
import org.dnyanyog.dto.AddCustomerResponse;
import org.dnyanyog.dto.DeleteResponse;
import org.dnyanyog.entity.Customer;
import org.dnyanyog.service.AddCustomerService;
import org.dnyanyog.service.DeleteCustomerService;
import org.dnyanyog.service.SearchCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerManagementController {

	@Autowired
	AddCustomerService addService;

	@Autowired
	SearchCustomerService searchService;
	
	@Autowired
	DeleteCustomerService deleteService;

	@PostMapping(path = "/api/v1/auth/customer", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public AddCustomerResponse addCustomer(@RequestBody AddCustomerRequest customerRequest) {
		return addService.addCustomer(customerRequest);
	}

	@GetMapping(path = "/api/v1/auth/customers")
	public List<Customer> getAllCustomers() {
		return searchService.getAllCustomers();
	}

	@GetMapping(path = "/api/v1/auth/{customer_id}")
	public AddCustomerResponse getSingleCustomers(@PathVariable Long customer_id) {
		return searchService.getSingleCustomer(customer_id);
	}

	@GetMapping(path = "/api/v1/auth/customer_ids")
	public List<Long> getAllCustomerIds() {
		return searchService.getAllCustomerIds();
	}
	
	@DeleteMapping(path ="/api/v1/auth/delete/{customer_id}")
	public DeleteResponse deleteCustomer(@PathVariable Long customer_id)
	{
		return deleteService.deleteCustomer(customer_id);
	}
}