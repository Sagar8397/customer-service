package org.customer.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class CustomerRequest {

	@NotNull(message = "First name cannot be null, it is mendatory")
	@NotBlank(message = "First name cannot be blank")
	private String first_name;

	@NotNull(message = "Last name cannot be null, it is mendatory")
	@NotBlank(message = "Last name cannot be blank")
	private String last_name;

	@NotNull(message = "Middle name cannot be null, it is mendatory")
	@NotBlank(message = "Middle name cannot be blank")
	private String middle_name;

	private String date_of_birth;
	private String address;
	private String zip;
	private String city;
	private String state;
	private String country;

	@NotNull(message = "Mobile number cannot be null")
	@NotBlank(message = "Mobile number cannot be blank")
	@Size(min = 10, max = 10, message = "Enter mobile number without country code")
	private String mobile_number;

	@Size(min = 10, max = 10, message = "Enter 10 digit home mobile number without country code")
	private String home_phone;

	@Size(min = 10, max = 10, message = "Enter 10 digit work mobile number without country code")
	private String work_phone;

	@Email(message = "Invalid email format")
	@Pattern(regexp = "[a-z]{5,50}(@)[a-z]{2,50}(.)[a-z]{2,10}", message = "Invalid email format")
	@NotBlank(message = "Invalid email format")
	private String email_id;

	private long customer_id;
	private long customer_code;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public void setWork_phone(String work_phone) {
		this.work_phone = work_phone;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public long getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(long customer_code) {
		this.customer_code = customer_code;
	}
}
