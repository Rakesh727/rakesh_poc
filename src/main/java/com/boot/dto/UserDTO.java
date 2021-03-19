package com.boot.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {

	private String userName;
   private String lastName;
	private String address;
	private long mobileNumber;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dob;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date doj;

	private String email;

	private Integer pinCode;

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", lastName=" + lastName + ", address=" + address + ", mobileNumber="
				+ mobileNumber + ", dob=" + dob + ", doj=" + doj + ", email=" + email + ", pinCode=" + pinCode + "]";
	}

	
}
