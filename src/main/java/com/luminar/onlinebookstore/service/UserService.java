package com.luminar.onlinebookstore.service;

import java.util.List;

import com.luminar.onlinebookstore.entity.UserEntity;

public interface UserService {
	void saveUser(UserEntity userEntity);

	List<UserEntity> getAll();

	UserEntity getById(Integer userId);

	boolean validateUser(String userEmail, String userPassword);

	UserEntity getUserByEmail(String email);

	void deleteUser(UserEntity userEntity);

	List<UserEntity> searchUsers(String query);
	
	 List<UserEntity> getAllSortedBy(String columnName, String order);

}
