package com.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.model.UserEntity;

@Path("/user")
public class UserCollection {
	UserDao userDao = new UserDaoImpl();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createUser")
	public UserEntity createUser(UserEntity user)
	{
		System.out.println("User ID : " + user.getId());
		System.out.println("Username  : " + user.getUsername());
		System.out.println("Password : " + user.getPassword());
		System.out.println("Email : " + user.getEmail());
		userDao.addUser(user);
		return user;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateUser")
	public UserEntity updateUser(UserEntity user)
	{
		UserEntity u = userDao.getUserById(user.getId());
		u.setEmail(user.getEmail());
		u.setId(user.getId());
		u.setPassword(user.getPassword());
		u.setUsername(user.getUsername());
		userDao.updateUser(u);
		return u;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteUser/{id}")
	public String deleteUser(@PathParam("id") Integer id)
	{
		UserEntity user = userDao.getUserById(id); 
		
		if(user!= null)
		{
			Integer roll = userDao.deleteUser(user);
			if(roll>0) {
				return "Delete Successfully";}
			return "Some Error";
		}
		return "Record Not Found";
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getById")
	public UserEntity getById(Integer id)
	{
		return userDao.getUserById(id);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllUsers")
	public List<UserEntity> getUsers()
	{
		return userDao.getAllUsers();
	}
}
