package org.dnyanyog.service;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface LoginService {

	public LoginResponse customerValidation(LoginRequest request);
}
