package com.ubs.auth.hub.service;

import com.ubs.auth.hub.dto.LoginDTO;
import com.ubs.auth.hub.dto.LoginRequestDTO;
import com.ubs.auth.hub.dto.UserDTO;

/**
 * The Class LoginService will connect with User repository to fetch user
 * details.
 */
public interface LoginService {

	/**
	 * Gets the user details by interacting with the user repository.
	 *
	 * @param loginDetails the login details
	 * @return the user details
	 */
	UserDTO getUserDetails(LoginRequestDTO loginDetails);

	/**
	 * Authorize.
	 *
	 * @param token the token
	 * @return the login DTO
	 */
	LoginDTO authorize(String token);
}
