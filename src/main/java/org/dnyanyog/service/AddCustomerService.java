package org.dnyanyog.service;

import org.dnyanyog.dto.AddCustomerRequest;
import org.dnyanyog.dto.AddCustomerResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface AddCustomerService {

	public AddCustomerResponse addCustomer(AddCustomerRequest customerRequest);
}
