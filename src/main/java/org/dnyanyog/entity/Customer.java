package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Component
public class Customer {
	
	@GeneratedValue()
	@Id
	@Column(name = "customer_id")
	private Long CustomerId;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String age;
	
	@Column
	private String email;
	
	public static Customer getInstance()
	{
		return new Customer();
	}

	public Long getCustomerId() {
		return CustomerId;
	}

	public Customer setCustomerId(Long customerId) {
		CustomerId = customerId;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public Customer setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Customer setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getAge() {
		return age;
	}

	public Customer setAge(String age) {
		this.age = age;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Customer setEmail(String email) {
		this.email = email;
		return this;
	}
}
