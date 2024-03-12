package org.customer.controller;

import java.util.List;

import org.customer.dto.CustomerRequest;
import org.customer.dto.CustomerResponse;
import org.customer.dto.SearchCustomerResponse;
import org.customer.entity.Customer;
import org.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class CustsomerServiceController {
	
	@Autowired
	CustomerServiceImpl CustomerServiceImpl;

	@PostMapping(path = "/api/v1/customer/add", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public CustomerResponse addCustomerDetails(@Valid @RequestBody CustomerRequest request) {
		return CustomerServiceImpl.addCustomerDetails(request);
	}

	@PostMapping(path = "/api/v1/customer/update/{id}", consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public CustomerResponse update(@PathVariable long id, @RequestBody CustomerRequest request) {
		return CustomerServiceImpl.updateCustomerDetails(id, request);
	}

	@GetMapping(path = "/api/v1/customer/search/{mobile_number}")
	public SearchCustomerResponse searchCustomerByMobileNumber(@PathVariable String mobile_number) {
		return CustomerServiceImpl.findByMobileNumber(mobile_number);
	}

	@GetMapping(path = "/api/v1/customer/search/customer_id/{customer_id}")
	public SearchCustomerResponse searchCustomerByUserId(@PathVariable String customer_id) {
		return CustomerServiceImpl.searchCustomerByUserId(customer_id);
	}

	@GetMapping(path = "/api/v1/customer/getAllCustomer")
	public List<Customer> getAllCustomer() {
		return CustomerServiceImpl.getAllCustomer();
	}
}
