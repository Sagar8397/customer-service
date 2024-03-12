package org.customer.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerData {

	private String first_name;
	private String last_name;
	private String middle_name;
	private String date_of_birth;
	private String address;
	private String zip;
	private String city;
	private String state;
	private String country;
	private String mobile_number;
	private String home_phone;
	private String work_phone;
	private String email_iD;
	private long customer_id;
	private long customer_code;

	public long getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(long customer_code) {
		this.customer_code = customer_code;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_lame) {
		this.last_name = last_lame;
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

	public void setWork_phone(String work_whone) {
		this.work_phone = work_whone;
	}

	public String getEmail_iD() {
		return email_iD;
	}

	public void setEmail_iD(String email_iD) {
		this.email_iD = email_iD;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
}
