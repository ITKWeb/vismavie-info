/**
 * 
 */
package com.itkweb.hday.service.impl;

import org.springframework.stereotype.Service;

import com.itkweb.hday.model.database.User;
import com.itkweb.hday.service.UserService;

/**
 * Implementation of {@link UserService}
 * 
 * @author Vincent DAVY
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itkweb.hday.service.UserService#getUserByLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User getUserByLogin(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itkweb.hday.service.UserService#addPlot(com.itkweb.hday.model.database.User)
	 */
	@Override
	public User addPlot(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itkweb.hday.service.UserService#deletePlot(java.lang.Long)
	 */
	@Override
	public void deletePlot(Long plotId) {
		// TODO Auto-generated method stub

	}

}
