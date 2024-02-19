package org.dnyanyog.service;

import java.util.List;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Customer;
import org.dnyanyog.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginResponse response;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public LoginResponse customerValidation(LoginRequest request) {
		
		List<Customer> list = customerRepo.findByUsernameAndPassword(request.getUsername(), request.getPassword());
		
		if(list.size()==1)
		{
			response.setStatus("Success");
			response.setMessage("Login successful");
		}else {
			response.setStatus("Fail");
			response.setMessage("Login failed");
		}
		return response;
	}

}
