package com.ubs.auth.hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.auth.hub.dto.LoginDTO;
import com.ubs.auth.hub.dto.LoginRequestDTO;
import com.ubs.auth.hub.dto.UserDTO;
import com.ubs.auth.hub.service.LoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserController will provide end points to expose user services to
 * clients.
 */
@RestController
@RequestMapping(value = "{application.context-path}")
@Slf4j
public class LoginController {

	/** The user service. */
	@Autowired
	private LoginService loginService;

	/**
	 * Gets the user details interacting with the service.
	 *
	 * @param loginDetails the login details
	 * @return the user details
	 */
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> getUserDetails(@RequestBody LoginRequestDTO loginDetails) {
		log.info("Login request recieved for User: {}", loginDetails.getUsername());
		return new ResponseEntity<>(loginService.getUserDetails(loginDetails), HttpStatus.OK);
	}

	/**
	 * Authorize login token.
	 *
	 * @param token the token
	 * @return the response entity
	 */
	@PostMapping(value = "/authorize")
	public ResponseEntity<LoginDTO> authorizeLoginToken(@RequestBody String token) {
		return new ResponseEntity<>(loginService.authorize(token), HttpStatus.OK);
	}
}
