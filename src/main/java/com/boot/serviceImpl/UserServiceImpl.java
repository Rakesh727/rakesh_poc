package com.boot.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.Constant;
import com.boot.dto.UserDTO;
import com.boot.exception.DataNotFoundException;
import com.boot.exception.SomethingWentWrong;
import com.boot.globalException.ErrorEntity;
import com.boot.globalException.SaveEntity;
import com.boot.globalException.SuccessEntity;
import com.boot.model.User;
import com.boot.repo.UserRepo;
import com.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseEntity<SaveEntity> saveRecord(UserDTO userDTO) {
		try {
			User user = new User();

			mapper.map(userDTO, user);

			user.setStatus(Boolean.TRUE);

			User entity = repo.save(user);

			SaveEntity saveEntity = new SaveEntity(Constant.DATA_SAVED, LocalDateTime.now(), HttpStatus.OK.value(),
					entity);
			return new ResponseEntity<>(saveEntity, HttpStatus.OK);

		} catch (RuntimeException ne) {
			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}

	}

	@Override
	public ResponseEntity<User> getUserById(Integer id) {
		try {
			Optional<User> record = repo.findById(id);
			return new ResponseEntity<>(record.get(), HttpStatus.OK);
		} catch (RuntimeException ne) {
			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}
	}

	@Override
	public ResponseEntity<?> getALlUser() {
		try {

			List<User> list = repo.findAll();
			if (!list.isEmpty()) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				ErrorEntity err = new ErrorEntity(Constant.NOT_FOUND, LocalDateTime.now(), Constant.NOT_FOUND_ERROR,
						HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<ErrorEntity>(err, HttpStatus.NOT_FOUND);
			}
		} catch (RuntimeException ex) {
			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}
	}

	@Override
	public ResponseEntity<?> deleteUserById(Integer id) {
		try {
			repo.deleteById(id);

			SuccessEntity success = new SuccessEntity(Constant.RECORD_DELETE, LocalDateTime.now(),
					HttpStatus.OK.value());
			return new ResponseEntity<SuccessEntity>(success, HttpStatus.OK);

		} catch (RuntimeException e) {
			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}
	}

	@Override
	public ResponseEntity<?> updateUserById(Integer id, UserDTO userDTO) {
		try {
			SaveEntity saveEntity = null;
			User user2 = repo.findById(id).get();
			user2.setId(id);
			mapper.map(userDTO, user2);

			User entity = repo.save(user2);

			if (entity != null) {
				saveEntity = new SaveEntity(Constant.RECORD_UPDATED, LocalDateTime.now(), HttpStatus.OK.value(),
						entity);

			}
			return new ResponseEntity<SaveEntity>(saveEntity, HttpStatus.OK);

		} catch (RuntimeException ne) {
			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}

	}

	@Override
	public ResponseEntity<?> softDeleteUserById(Integer id) {
		try {
			repo.softDelete(id);
			SuccessEntity success = new SuccessEntity(Constant.RECORD_DELETE, LocalDateTime.now(),
					HttpStatus.OK.value());
			return new ResponseEntity<SuccessEntity>(success, HttpStatus.OK);
		} catch (RuntimeException ne) {
			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}

	}

	@Override
	public ResponseEntity<?> getUserByName(String name) {
		try {
			List<User> user = repo.findByUserName(name);
			if (!user.isEmpty()) {
				return new ResponseEntity<List<User>>(user, HttpStatus.OK);
			} else {
				ErrorEntity err = new ErrorEntity(Constant.NOT_FOUND, LocalDateTime.now(), Constant.NOT_FOUND_ERROR,
						HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<ErrorEntity>(err, HttpStatus.NOT_FOUND);
			}

		} catch (RuntimeException ne) {

			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}

	}

	@Override
	public ResponseEntity<?> getAllUserDataByDoj() {
		try {
//	TreeSet<User> ts=new TreeSet<>();
			// List<User> list = repo.findAll();
			// System.out.println(list);
			// ts.addAll(list);
			List<User> list = repo.findByOrderByDojAsc();
			if (!list.isEmpty()) {
				return new ResponseEntity<>(list, HttpStatus.OK);

			} else {
				ErrorEntity err = new ErrorEntity(Constant.NOT_FOUND, LocalDateTime.now(), Constant.NOT_FOUND_ERROR,
						HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<ErrorEntity>(err, HttpStatus.NOT_FOUND);
			}
		} catch (RuntimeException ne) {
			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}
	}

	@Override
	public ResponseEntity<?> getUserByAddress(String address) {

		try {
			List<User> user = repo.findByAddress(address);
			if (!user.isEmpty()) {
				return new ResponseEntity<List<User>>(user, HttpStatus.OK);
			} else {
				ErrorEntity err = new ErrorEntity(Constant.NOT_FOUND, LocalDateTime.now(), Constant.NOT_FOUND_ERROR,
						HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<ErrorEntity>(err, HttpStatus.NOT_FOUND);
			}

		} catch (RuntimeException ne) {

			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}

	}

	@Override
	public ResponseEntity<?> getAllUserDataByDob() {
		try {

			List<User> list = repo.findByOrderByDobAsc();
			if (!list.isEmpty()) {
				return new ResponseEntity<>(list, HttpStatus.OK);
			} else {
				ErrorEntity err = new ErrorEntity(Constant.NOT_FOUND, LocalDateTime.now(), Constant.NOT_FOUND_ERROR,
						HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<ErrorEntity>(err, HttpStatus.NOT_FOUND);
			}
		} catch (RuntimeException ne) {
			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}
	}

	@Override
	public ResponseEntity<?> getUserByPinCode(Integer pinCode) {
		try {
			List<User> user = repo.findByPinCode(pinCode);
			if (!user.isEmpty()) {
				return new ResponseEntity<List<User>>(user, HttpStatus.OK);
			} else {
				ErrorEntity err = new ErrorEntity(Constant.NOT_FOUND, LocalDateTime.now(), Constant.NOT_FOUND_ERROR,
						HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<ErrorEntity>(err, HttpStatus.NOT_FOUND);
			}

		} catch (RuntimeException ne) {

			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}

	}

	@Override
	public ResponseEntity<?> getUserByLastName(String lastName) {
		try {
			List<User> user = repo.findByLastName(lastName);
			if (!user.isEmpty()) {
				return new ResponseEntity<List<User>>(user, HttpStatus.OK);
			} else {
				ErrorEntity err = new ErrorEntity(Constant.NOT_FOUND, LocalDateTime.now(), Constant.NOT_FOUND_ERROR,
						HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<ErrorEntity>(err, HttpStatus.NOT_FOUND);
			}

		} catch (RuntimeException ne) {

			throw new SomethingWentWrong(Constant.SOME_THING_WENT_WRONG);
		}

	}

}