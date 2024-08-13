package com.luminar.onlinebookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luminar.onlinebookstore.entity.UserEntity;
import com.luminar.onlinebookstore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public boolean validateUser(String userEmail, String userPassword) {

//	        return "akhila123@gmail.com".equals(userEmail) && "akhila@123".equals(userPassword);
		UserEntity user = userRepository.findByUserEmail(userEmail);

		// Check if the user exists and if the password matches
		return user != null && userPassword.equals(user.getUserPassword());
	}

	@Override
	public UserEntity getUserByEmail(String userEmail) {
		return userRepository.findByUserEmail(userEmail);
	}

	/*
	 * @Override public void saveUser(UserEntity userEntity) {
	 * userRepository.save(userEntity); }
	 */
	@Override
	@Transactional
	public void saveUser(UserEntity userEntity) {
		if (userEntity.getUserId() == null) {

			userRepository.save(userEntity);
		} else {
			UserEntity userUpdate = userRepository.findById(userEntity.getUserId()).get();

			userUpdate.setUserName(userEntity.getUserName());
			userUpdate.setUserContact(userEntity.getUserContact());
			userUpdate.setUserEmail(userEntity.getUserEmail());
			userUpdate.setUserUsername(userEntity.getUserUsername());
			userUpdate.setUserPassword(userEntity.getUserPassword());
			userUpdate.setUserRole(userEntity.getUserRole());
			userRepository.save(userUpdate);
		}
	}

	@Override
	public List<UserEntity> getAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity getById(Integer userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public void deleteUser(UserEntity userEntity) {
		userRepository.delete(userEntity);
	}

	@Override
	public List<UserEntity> searchUsers(String username) {

		return userRepository.findByUserNameContaining(username);
	}

	@Override
	public List<UserEntity> getAllSortedBy(String columnName, String order) {
	    Sort.Direction sortDirection = "asc".equalsIgnoreCase(order) ? Sort.Direction.ASC : Sort.Direction.DESC;
	    return userRepository.findAll(Sort.by(sortDirection, columnName));
	}
}
