package com.boot.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Modifying
	@Transactional
	@Query("update User u set u.status=false where u.id=:id")
	void softDelete(Integer id);

	// @Query("from User u where u.userName=:name")
	public List<User> findByUserName(String name);

	public List<User> findByLastName(String lastName);

	// @Query("from User u where u.pinCode=:pinCode")
	public List<User> findByPinCode(Integer pinCode);
	
	public List<User> findByAddress(String address);

	public List<User> findByOrderByDojAsc();

	public List<User> findByOrderByDobAsc();

}
