package com.ubs.auth.hub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubs.auth.hub.dto.LoginDTO;
import com.ubs.auth.hub.dto.LoginRequestDTO;
import com.ubs.auth.hub.dto.UserDTO;
import com.ubs.auth.hub.repository.LoginRepository;
import com.ubs.auth.hub.service.LoginService;

/**
 * The Class LoginServiceImpl implements all methods in LoginService.
 */
@Service
public class LoginServiceImpl implements LoginService {

	/** The user repository. */
	@Autowired
	private LoginRepository loginRepository;


	/**
	 * Gets the user details.
	 *
	 * @param loginRequestDTO the login request DTO
	 * @return the user details
	 */
	@Override
	public UserDTO getUserDetails(LoginRequestDTO loginRequestDTO) {
		validateRequestParameters(loginRequestDTO);
		LoginDTO loginDetails = loginRepository.getLoginDetails(loginRequestDTO.getUsername(),
				loginRequestDTO.getPassword());
		String token = generateLoginToken(loginDetails);
		cacheToken(token);
		return UserDTO.builder().idUser(loginDetails.getIdUser()).token(token).build();
	}

	/**
	 * Cache token.
	 *
	 * @param token the token
	 */
	private void cacheToken(String token) {
		// TODO This method will cache this token in memory or on distributed cache so
		// that we can validate it in future.

	}

	/**
	 * Validate request parameters.
	 *
	 * @param loginRequestDTO the login request DTO
	 */
	private void validateRequestParameters(LoginRequestDTO loginRequestDTO) {
		// TO-DO add validations to loginRequestDTO, this will throw exception which
		// will be handled by global exception handler in case of issues with the input
		// parameters
	}

	/**
	 * Generate login token.
	 *
	 * @param loginDetails the login details
	 * @return the string
	 */
	private String generateLoginToken(LoginDTO loginDetails) {
		String encryptedToken = null;
		if (null != loginDetails) {
			String token = new StringBuilder().append(loginDetails.getIdUser()).append(loginDetails.getIdRole())
					.append(loginDetails.getRoleDescription()).toString();
			encryptedToken = encryptToken(token);
		}
		return encryptedToken;
	}

	/**
	 * Encrypt token.
	 *
	 * @param token the token
	 * @return the string
	 */
	private String encryptToken(String token) {
		// TODO This method will encrypt the token so that it cann't be misused by MIM
		// attack.
		return null;
	}

}
