package com.ubs.auth.hub.service;

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
	 * @param username the username
	 * @return the user details
	 */
	UserDTO getUserDetails(LoginRequestDTO loginDetails);
}
