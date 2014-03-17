package com.itkweb.hday.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.itkweb.hday.dao.UserDAO;
import com.itkweb.hday.model.database.User;

public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManager entityManager;


	@Override
	public User getById(Long id) {

		TypedQuery<User> query = entityManager.createQuery("select u from User where id = :id", User.class);

		query.setParameter("id", id);

		User user = query.getSingleResult();

		return user;
	}

}
