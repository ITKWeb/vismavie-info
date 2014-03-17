/**
 * 
 */
package com.itkweb.hday.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itkweb.hday.model.json.ErrorMessage;
import com.itkweb.hday.model.json.LoginData;

/**
 * Login controller class
 * 
 * @author Vincent DAVY
 * 
 */
@RestController
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/login")
	public ResponseEntity<?> login(@Valid LoginData loginData, BindingResult result) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Received authentication data : " + loginData);
		}

		ResponseEntity<?> responseEntity = null;
		if (result.hasErrors()) { // check if we have error (empty fields)
			ErrorMessage error = new ErrorMessage();
			error.setErrorMessage(messageSource.getMessage("hday.loginPasswordNoEmpty", null, null));
			responseEntity = new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
		}

		// check login and password

		return responseEntity;
	}
}
