package com.boot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.boot.dto.UserDTO;
import com.boot.globalException.SaveEntity;
import com.boot.model.User;

public interface UserService {
	
	public ResponseEntity<SaveEntity> saveRecord(UserDTO std);
	public ResponseEntity<?> getUserById(Integer id)throws RuntimeException;
	public ResponseEntity<?> getALlUser();
	public ResponseEntity<?>deleteUserById(Integer id)throws RuntimeException;
	public ResponseEntity<?>updateUserById(Integer id,UserDTO user);
	ResponseEntity<?>softDeleteUserById(Integer id);
	ResponseEntity<?> getUserByName(String name);
	ResponseEntity<?>getAllUserDataByDoj();
	ResponseEntity<?>getAllUserDataByDob();
	ResponseEntity<?> getUserByPinCode(Integer pinCode);
	ResponseEntity<?> getUserByLastName(String lastName);
	public ResponseEntity<?> getUserByAddress(String address);
	
	
}
