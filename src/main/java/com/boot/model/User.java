package com.boot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class User{// implements Comparable<User> {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String userName;
	private String lastName;
	private String address;
	private long mobileNumber;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date doj;
	
	@JsonIgnore
	private boolean status;
	
	private String email;
	
	private Integer pinCode;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
		
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public Date getDob() {
		return dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", lastName=" + lastName + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", dob=" + dob + ", doj=" + doj + ", status=" + status + ", email="
				+ email + ", pinCode=" + pinCode + "]";
	}
	
	
	
	/*@Override
	public int compareTo(User obj) {
		Date doj1=this.doj;
		Date doj2=obj.getDoj();	
		return doj1.compareTo(doj2);
	}*/
	
	
	
	
	

}
