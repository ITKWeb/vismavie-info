package com.itkweb.hday.service;

import com.itkweb.hday.model.database.User;

public interface UserService {

	/**
	 * Get user data
	 * 
	 * @param login
	 *            the user login
	 * @param password
	 *            the user password
	 * @return User with Farm and Plots, or <code>null</code> if user not found
	 */
	public User getUserByLogin(String login, String password);

	public User addPlot(User user);

	public User modifyPlot(User user);

	/**
	 * 
	 * @param plotId
	 */
	public void deletePlot(Long plotId);
}
