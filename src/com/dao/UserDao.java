package com.dao;

import java.util.List;

import com.model.UserEntity;

public interface UserDao {
	public Integer addUser(UserEntity user);

	public Integer updateUser(UserEntity user);

	public Integer deleteUser(UserEntity user);

	public UserEntity getUserById(Integer id);

	public List<UserEntity> getAllUsers();
}
