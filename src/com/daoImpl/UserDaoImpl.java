package com.daoImpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.connection.Connections;
import com.dao.UserDao;
import com.model.UserEntity;

public class UserDaoImpl implements UserDao{
	
	static SessionFactory factory = Connections.getConnection();

	@Override
	public Integer addUser(UserEntity user) {
		Integer roll = null;
		try {
			
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			roll = (Integer) session.save(user);
			
			transaction.commit();
			System.out.println("Added Successfully.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return roll;
	}

	@Override
	public Integer updateUser(UserEntity user) {
		Integer row = null;
		try {
			
			Session session = factory.openSession();

			Transaction transaction =session.beginTransaction();

			 session.update(user);
			row = 1;
			
			transaction.commit();
			System.out.println("Update Successfully.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deleteUser(UserEntity user) {
		Integer roll = null;
		try {
			
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			 session.remove(user);
			roll = 1;
			
			transaction.commit();
			System.out.println("Deleted Successfully.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return roll;
	}

	@Override
	public UserEntity getUserById(Integer id) {
		UserEntity user = null;
		try {
			
			Session session =  factory.openSession();

			Transaction transaction = session.beginTransaction();

			user = session.get(UserEntity.class, id);
			
			transaction.commit();
			System.out.println("Sucessfully get Data.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return user;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		List<UserEntity> user = new ArrayList<UserEntity>();
		try {
			
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			user =  session.createQuery("from UserEntity").getResultList();
			
			transaction.commit();
			System.out.println("Successfully Get All Data.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return user;
	}

}
