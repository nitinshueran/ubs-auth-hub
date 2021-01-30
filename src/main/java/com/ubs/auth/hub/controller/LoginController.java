package com.ubs.auth.hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.auth.hub.dto.LoginRequestDTO;
import com.ubs.auth.hub.dto.UserDTO;
import com.ubs.auth.hub.service.LoginService;

/**
 * The Class UserController will provide end points to expose user services to
 * clients.
 */
@RestController
@RequestMapping(value = "{application.context-path}")
public class LoginController {

	/** The user service. */
	@Autowired
	private LoginService loginService;

	/**
	 * Gets the user details interacting with the service.
	 *
	 * @param username the username
	 * @return the user details
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> getUserDetails(@RequestBody LoginRequestDTO loginDetails) {
		return new ResponseEntity<>(loginService.getUserDetails(loginDetails), HttpStatus.OK);
	}

}
