package com.itkweb.hday.dao;

import com.itkweb.hday.model.database.User;

public interface UserDAO {


	public User getById(Integer id);

	public User saveOrUpdate(User user);
}
