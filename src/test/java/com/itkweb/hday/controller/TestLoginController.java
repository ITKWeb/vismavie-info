/**
 * 
 */
package com.itkweb.hday.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.itkweb.hday.model.json.LoginData;
import com.itkweb.hday.service.UserService;

/**
 * Test the {@link LoginController}
 * 
 * @author Vincent DAVY
 * 
 */
public class TestLoginController extends AbstractTestController {

	// mocks (with injection)
	@Autowired
	@InjectMocks
	private LoginController loginController;

	// mock part
	@Mock
	private UserService userServiceMock;

	/**
	 * Test an empty request
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEmptyRequest() throws Exception {
		// setup data
		LoginData loginData = new LoginData();
		loginData.setLogin("");
		loginData.setPassword("");
		String json = objectMapper.writeValueAsString(loginData);

		// call controller
		mockMvc.perform(MockMvcRequestBuilders.post("/server/rest/login").content(json))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.errorMessage").value(
								messageSource.getMessage("hday.loginPasswordNoEmpty", null, null)));
	}

	@Test
	public void testWrongUserLoginPasswordRequest() throws Exception {
		// setup data
		LoginData loginData = new LoginData();
		loginData.setLogin("login");
		loginData.setPassword("pass");
		String json = objectMapper.writeValueAsString(loginData);

		// init mock
		when(userServiceMock.getUserByLogin(loginData.getLogin(), loginData.getPassword())).thenReturn(null);

		// call controller
		mockMvc.perform(MockMvcRequestBuilders.post("/server/rest/login").content(json))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.errorMessage").value(
								messageSource.getMessage("hday.wrongLoginPassword", null, null)));

		// verify mock
		verify(userServiceMock).getUserByLogin(loginData.getLogin(), loginData.getPassword());
	}

}
