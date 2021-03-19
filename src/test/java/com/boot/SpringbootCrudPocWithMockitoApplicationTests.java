package com.boot;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.boot.dto.UserDTO;
import com.boot.globalException.SaveEntity;
import com.boot.model.User;
import com.boot.repo.UserRepo;
import com.boot.serviceImpl.UserServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringbootCrudPocWithMockitoApplicationTests {
	
	
	@Mock
	UserRepo repo;
	
	@InjectMocks
	UserServiceImpl service;
	User user=new User();
	UserDTO dto=new UserDTO();
	SaveEntity saveEntity=new SaveEntity();
	
	@BeforeEach
	public void setUp() {
		List<User> list=new ArrayList();
	
		
	//	dto.setId(1);
		dto.setUserName("Rakesh");
		dto.setMobileNumber(5432);
		dto.setAddress("Sakri");
		dto.setDob(new Date(2020,05,11));
		dto.setDoj(new Date(2020,03,12));
		dto.setEmail("rrsonawane@gmail.com");
		
		
		
		user.setId(1);
		user.setUserName("Rakesh");
		user.setMobileNumber(5432);
		user.setAddress("Sakri");
		user.setDob(new Date(2020,05,11));
		user.setDoj(new Date(2020,03,12));
		user.setEmail("rrsonawane@gmail.com");
		user.setStatus(Boolean.TRUE);
		
		User user1=new User();
		user1.setId(2);
		user1.setUserName("Dipak");
		user1.setMobileNumber(876);
		user1.setAddress("Dhule");
		user1.setDob(new Date(1990,02,11));
		user1.setDoj(new Date(1999,04,14));
		user1.setEmail("rakeshpatil@gmail.com");
		user1.setStatus(Boolean.TRUE);
		
		list.add(user);
		list.add(user1);
		
		saveEntity.setData(user);
		saveEntity.setMessage(Constant.DATA_SAVED);
		saveEntity.setStatusCode(HttpStatus.OK.value());
		saveEntity.setTimeStamp(LocalDateTime.now());
			
	}
	
	@Test
	@DisplayName("Test Case for Saving Data")
	public void testForSavingData() {
		when(repo.save(user)).thenReturn(user);
		 ResponseEntity<SaveEntity> responseEntity = service.saveRecord(dto);
		SaveEntity body = responseEntity.getBody();
		Assertions.assertEquals(saveEntity, body);
	
	}

	
}
