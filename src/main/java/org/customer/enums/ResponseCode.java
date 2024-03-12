package org.customer.enums;

public enum ResponseCode {

	ADD_CUSTOMER_SUCCESS("Success", "Customer Added Successfully"),
	CUSTOMER_EMAIL_ALREADY_EXIST("Unsuccess", "Customer Email Is Already Exist"),
	VALID_CUSTOMER("Success", "Customer Found Successfully"),
	INVALID_CUSTOMER("Unsuccess", "Customer Not Found");

	private final String status;
	private final String message;

	ResponseCode(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
