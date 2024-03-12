package org.customer.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {

	private String status;
	private String message;
	private long customer_code;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getCustomer_code() {
		return customer_code;
	}

	public void setCustomer_code(long customer_code) {
		this.customer_code = customer_code;
	}
}
