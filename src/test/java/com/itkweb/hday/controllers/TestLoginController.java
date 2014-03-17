/**
 * 
 */
package com.itkweb.hday.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.itkweb.hday.model.json.LoginData;

/**
 * Test the {@link LoginController}
 * 
 * @author Vincent DAVY
 * 
 */
public class TestLoginController extends AbstractTestController {

	/**
	 * Test an empty request
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEmptyRequest() throws Exception {
		// steup data
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

}
