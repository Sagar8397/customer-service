package org.customer.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.customer.dto.CustomerRequest;
import org.customer.dto.CustomerResponse;
import org.customer.dto.SearchCustomerResponse;
import org.customer.entity.Customer;
import org.customer.enums.ResponseCode;
import org.customer.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	CustomerResponse customerResponse;

	@Autowired
	SearchCustomerResponse searchCustomerResponse;

	public CustomerResponse addCustomerDetails(CustomerRequest customerRequest) {

//		if (customerRepo.existsByEmail_id(customerRequest.getEmail_iD())) {
//			customerResponse.setStatus(ResponseCode.CUSTOMER_EMAIL_ALREADY_EXIST.getStatus());
//			customerResponse.setMessage(ResponseCode.CUSTOMER_EMAIL_ALREADY_EXIST.getMessage());
//			customerResponse.setCustomer_code(0000);
//		} else {
//
//			Customer customerTable = Customer.getInstance().setFirst_name(customerRequest.getFirst_name())
//					.setMiddle_name(customerRequest.getMiddle_name()).setLast_name(customerRequest.getLast_name())
//					.setDate_of_birth(customerRequest.getDate_of_birth())
//					.setAddress_line1(customerRequest.getAddress()).setZip(customerRequest.getZip())
//					.setCity(customerRequest.getCity()).setState(customerRequest.getState())
//					.setCountry(customerRequest.getCountry()).setMobile_phone(customerRequest.getMobile_number())
//					.setHome_phone(customerRequest.getHome_phone()).setWork_phone(customerRequest.getWork_phone())
//					.setEmail_id(customerRequest.getEmail_iD()).setCustomer_id(customerRequest.getCustomer_id());
//
//			try {
//				customerTable = customerRepo.save(customerTable);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			customerResponse.setStatus(ResponseCode.ADD_CUSTOMER_SUCCESS.getStatus());
//			customerResponse.setMessage(ResponseCode.ADD_CUSTOMER_SUCCESS.getMessage());
//		}
		Customer customerTable = Customer.getInstance()
				.setCustomer_id(customerRequest.getCustomer_id())
				.setFirst_name(customerRequest.getFirst_name())
				.setMiddle_name(customerRequest.getMiddle_name())
				.setLast_name(customerRequest.getLast_name())
				.setEmail_id(customerRequest.getEmail_id())
				.setDate_of_birth(customerRequest.getDate_of_birth())
				.setAddress_line1(customerRequest.getAddress())
				.setZip(customerRequest.getZip())
				.setCity(customerRequest.getCity())
				.setState(customerRequest.getState())
				.setCountry(customerRequest.getCountry())
				.setMobile_phone(customerRequest.getMobile_number())
				.setHome_phone(customerRequest.getHome_phone())
				.setWork_phone(customerRequest.getWork_phone());
		
		customerTable = customerRepo.save(customerTable);
		
		customerResponse.setStatus(ResponseCode.ADD_CUSTOMER_SUCCESS.getStatus());
		customerResponse.setMessage(ResponseCode.ADD_CUSTOMER_SUCCESS.getMessage());
		customerResponse.setCustomer_code(customerTable.getCustomer_code());
		
		return customerResponse;
	}

	public CustomerResponse updateCustomerDetails(long id, CustomerRequest customerRequest) {

		Optional<Customer> customerTable = customerRepo.findById(id);
		if (customerTable.isEmpty()) {
			customerResponse.setStatus(ResponseCode.INVALID_CUSTOMER.getStatus());
			customerResponse.setMessage(ResponseCode.INVALID_CUSTOMER.getMessage());
//			customerResponse.setCustomer_code(0000);
		} else {
			Customer customer = Customer.getInstance().setFirst_name(customerRequest.getFirst_name())
					.setMiddle_name(customerRequest.getMiddle_name()).setLast_name(customerRequest.getLast_name())
					.setDate_of_birth(customerRequest.getDate_of_birth())
					.setAddress_line1(customerRequest.getAddress()).setZip(customerRequest.getZip())
					.setCity(customerRequest.getCity()).setState(customerRequest.getState())
					.setCountry(customerRequest.getCountry()).setMobile_phone(customerRequest.getMobile_number())
					.setHome_phone(customerRequest.getHome_phone()).setWork_phone(customerRequest.getWork_phone())
					.setEmail_id(customerRequest.getEmail_id()).setCustomer_id(customerRequest.getCustomer_id());
		}
		return customerResponse;
	}

	public SearchCustomerResponse findByMobileNumber(String mobile_number) {

		List<Customer> customerTable = customerRepo.findByMobile_number(mobile_number);
		if (customerTable.isEmpty()) {
			searchCustomerResponse.setStatus(ResponseCode.INVALID_CUSTOMER.getStatus());
			searchCustomerResponse.setMessage(ResponseCode.INVALID_CUSTOMER.getMessage());
		} else{
			Customer receivedData = customerTable.get(0);

			searchCustomerResponse.setStatus(ResponseCode.VALID_CUSTOMER.getStatus());
			searchCustomerResponse.setMessage(ResponseCode.VALID_CUSTOMER.getMessage());
			searchCustomerResponse.getCustomerData().setCustomer_code(receivedData.getCustomer_code());
			searchCustomerResponse.getCustomerData().setCustomer_id(receivedData.getCustomer_id());
			searchCustomerResponse.getCustomerData().setFirst_name(receivedData.getFirst_name());
			searchCustomerResponse.getCustomerData().setMiddle_name(receivedData.getMiddle_name());
			searchCustomerResponse.getCustomerData().setLast_name(receivedData.getLast_name());
			searchCustomerResponse.getCustomerData().setDate_of_birth(receivedData.getDate_of_birth());
			searchCustomerResponse.getCustomerData().setAddress(receivedData.getAddress_line1());
			searchCustomerResponse.getCustomerData().setZip(receivedData.getZip());
			searchCustomerResponse.getCustomerData().setCity(receivedData.getCity());
			searchCustomerResponse.getCustomerData().setState(receivedData.getState());
			searchCustomerResponse.getCustomerData().setCountry(receivedData.getCountry());
			searchCustomerResponse.getCustomerData().setMobile_number(receivedData.getMobile_phone());
			searchCustomerResponse.getCustomerData().setHome_phone(receivedData.getHome_phone());
			searchCustomerResponse.getCustomerData().setWork_phone(receivedData.getWork_phone());
			searchCustomerResponse.getCustomerData().setEmail_iD(receivedData.getEmail_id());
		}
		return searchCustomerResponse;
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customerRepo.findAll();
	}

	@Override
	public SearchCustomerResponse searchCustomerByUserId(String customer_id) {
		
		List<Customer> customerTable = customerRepo.findByUser_id(customer_id);
		
		if(customerTable.isEmpty())
		{
			searchCustomerResponse.setStatus("Unsuccess");
			searchCustomerResponse.setMessage("Customer not found");
		}
		else
		{
			Customer receivedData = customerTable.get(1);
			
			searchCustomerResponse.setStatus("Success");
			searchCustomerResponse.setMessage("Customer found successfully");
			searchCustomerResponse.getCustomerData().setCustomer_code(receivedData.getCustomer_code());
			searchCustomerResponse.getCustomerData().setCustomer_id(receivedData.getCustomer_id());
			searchCustomerResponse.getCustomerData().setFirst_name(receivedData.getFirst_name());
			searchCustomerResponse.getCustomerData().setMiddle_name(receivedData.getMiddle_name());
			searchCustomerResponse.getCustomerData().setLast_name(receivedData.getLast_name());
			searchCustomerResponse.getCustomerData().setDate_of_birth(receivedData.getDate_of_birth());
			searchCustomerResponse.getCustomerData().setAddress(receivedData.getAddress_line1());
			searchCustomerResponse.getCustomerData().setZip(receivedData.getZip());
			searchCustomerResponse.getCustomerData().setCity(receivedData.getCity());
			searchCustomerResponse.getCustomerData().setState(receivedData.getState());
			searchCustomerResponse.getCustomerData().setCountry(receivedData.getCountry());
			searchCustomerResponse.getCustomerData().setMobile_number(receivedData.getMobile_phone());
			searchCustomerResponse.getCustomerData().setHome_phone(receivedData.getHome_phone());
			searchCustomerResponse.getCustomerData().setWork_phone(receivedData.getWork_phone());
			searchCustomerResponse.getCustomerData().setEmail_iD(receivedData.getEmail_id());
		}
		
		return searchCustomerResponse;
	}
}
