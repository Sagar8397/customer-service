package org.dnyanyog.service;

import org.dnyanyog.dto.DeleteResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface DeleteCustomerService {

	public DeleteResponse deleteCustomer(Long customer_id);
}
