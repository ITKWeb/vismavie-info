package com.itkweb.hday.service;

import com.itkweb.hday.model.database.User;

public interface UserService {


	/**
	 * 
	 * @param login
	 * @param password
	 * @return User with Farm and Plots
	 */
	public User getUserByLogin(String login, String password);


	public User addPlot(User user);

	/**
	 * 
	 * @param plotId
	 */
	public void deletePlot(Long plotId);
}
