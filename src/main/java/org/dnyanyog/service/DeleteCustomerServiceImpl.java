package org.dnyanyog.service;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.dto.DeleteResponse;
import org.dnyanyog.entity.Customer;
import org.dnyanyog.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerServiceImpl implements DeleteCustomerService {

	@Autowired
	DeleteResponse response;
	
	@Autowired
	CustomerRepository customerRepo;
	
	public DeleteResponse deleteCustomer(Long customer_id)
	{
		Optional<Customer> list = customerRepo.findById(customer_id);
		
		if(list.isEmpty())
		{
			response.setStatus("Fail");
			response.setMessage("Customer not found");
		}else {
			Customer c = list.get();
			customerRepo.delete(c);
			response.setStatus("Success");
			response.setMessage("Customer deleted successfully");
		}
		return response;
	}
}
