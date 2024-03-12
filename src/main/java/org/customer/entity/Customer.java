package org.customer.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "customer_seq") // Auto generated (DB => sequence), primary key
	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
	@Id
	@Column(nullable = false, insertable = false, updatable = false)
	private long customer_code;

	@Column(updatable = true, nullable = false)
	private long customer_id;

	@Column
	private String first_name;

	@Column
	private String last_name;

	@Column
	private String middle_name;

	@Email(message = "Invalid email format")
	@Pattern(regexp = "[a-z]{5,50}(@)[a-z]{2,50}(.)[a-z]{2,10}")
	@Column(unique = true)
	private String email_id;

	@Column
	private String date_of_birth;

	@Column
	private String address;

	@Column
	private String zip;

	@Column
	private String city;

	@Column
	private String state;

	@Column
	private String country;

	@Column
	private String mobile_number;

	@Column
	private String home_phone;

	@Column
	private String work_phone;

	public static Customer getInstance() {
		return new Customer();
	}

	public long getCustomer_code() {
		return customer_code;
	}

	public Customer setCustomer_code(long customer_code) {
		this.customer_code = customer_code;

		return this;
	}

	public String getFirst_name() {
		return first_name;
	}

	public Customer setFirst_name(String first_name) {
		this.first_name = first_name;
		return this;
	}

	public String getLast_name() {
		return last_name;
	}

	public Customer setLast_name(String last_name) {
		this.last_name = last_name;

		return this;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public Customer setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
		return this;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public Customer setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;

		return this;
	}

	public String getAddress_line1() {
		return address;
	}

	public Customer setAddress_line1(String address) {
		this.address = address;
		return this;
	}

	public String getZip() {
		return zip;
	}

	public Customer setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Customer setCity(String city) {
		this.city = city;

		return this;
	}

	public String getState() {
		return state;
	}

	public Customer setState(String state) {
		this.state = state;

		return this;
	}

	public String getCountry() {
		return country;
	}

	public Customer setCountry(String country) {
		this.country = country;

		return this;
	}

	public String getMobile_phone() {
		return mobile_number;
	}

	public Customer setMobile_phone(String mobile_phone) {
		this.mobile_number = mobile_phone;

		return this;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public Customer setHome_phone(String home_phone) {
		this.home_phone = home_phone;

		return this;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public Customer setWork_phone(String work_phone) {
		this.work_phone = work_phone;

		return this;
	}

	public String getEmail_id() {
		return email_id;
	}

	public Customer setEmail_id(String email_id) {
		this.email_id = email_id;

		return this;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public Customer setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
		return this;
	}
}
