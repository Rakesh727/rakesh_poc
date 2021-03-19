package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dto.UserDTO;
import com.boot.repo.UserRepo;
import com.boot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	private UserRepo repo;

	@PostMapping("/save")
	public ResponseEntity<?> saveRecord(@RequestBody UserDTO userDTO) {
		return service.saveRecord(userDTO);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) throws Exception {
		return service.getUserById(id);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getALlUser() {
		return service.getALlUser();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id) {
		return service.deleteUserById(id);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
		return service.updateUserById(id, userDTO);
	}

	@PutMapping("/softdelete/{id}")
	public ResponseEntity<?> softDeleteUserById(@PathVariable("id") Integer id) {
		return service.softDeleteUserById(id);
	}

	@GetMapping("/getName/{name}")
	public ResponseEntity<?> getUserByName(@PathVariable("name") String name) throws Exception {
		return service.getUserByName(name);
	}

	@GetMapping("/doj")
	public ResponseEntity<?> getAllUserDataByDoj() {
		return service.getAllUserDataByDoj();

	}

	@GetMapping("/dob")
	public ResponseEntity<?> getAllUserDataByDob() {
		return service.getAllUserDataByDob();

	}

	@GetMapping("/getPinCode/{pin}")
	public ResponseEntity<?> getUserByPinCode(@PathVariable("pin") Integer pinCode) throws Exception {
		return service.getUserByPinCode(pinCode);
	}

	@GetMapping("/lastName/{name}")
	public ResponseEntity<?> getUserByLastName(@PathVariable("name") String name) throws Exception {
		return service.getUserByLastName(name);
	}

	@GetMapping("/getAddress/{address}")
	public ResponseEntity<?> getUserByAddress(@PathVariable("address") String address) throws Exception {
		return service.getUserByAddress(address);
	}

}
