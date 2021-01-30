package com.ubs.auth.hub.service.impl;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.trivago.triava.tcache.Cache;
import com.trivago.triava.tcache.TCacheFactory;
import com.trivago.triava.tcache.core.Builder;
import com.ubs.auth.hub.dto.LoginDTO;
import com.ubs.auth.hub.dto.LoginRequestDTO;
import com.ubs.auth.hub.dto.UserDTO;
import com.ubs.auth.hub.entity.User;
import com.ubs.auth.hub.repository.LoginRepository;
import com.ubs.auth.hub.service.LoginService;

/**
 * The Class LoginServiceImpl implements all methods in LoginService.
 */
@Service
public class LoginServiceImpl implements LoginService {

	/** The cache. */
	private static Cache<String, LoginDTO> cache;

	static {
		Builder<String, LoginDTO> builder = TCacheFactory.standardFactory().builder();
		cache = builder.setMaxCacheTime(10, TimeUnit.MINUTES).build();
	}

	/** The user repository. */
	@Autowired
	private LoginRepository loginRepository;

	/** The key. */
	@Value("${login.creds.encryption.key}")
	private String key;

	/**
	 * Gets the user details.
	 *
	 * @param loginRequestDTO the login request DTO
	 * @return the user details
	 */
	@Override
	public UserDTO getUserDetails(LoginRequestDTO loginRequestDTO) {
		validateRequestParameters(loginRequestDTO);
		User user = loginRepository.findByUsernameAndPassword(loginRequestDTO.getUsername(),
				loginRequestDTO.getPassword());
		if (null != user && null != user.getRole()) {
			LoginDTO loginDetails = LoginDTO.builder().idRole(user.getRole().getIdRole()).idUser(user.getIdUser())
					.roleDescription(user.getRole().getRoleDescription()).build();
			String token = generateLoginToken(loginDetails);
			cacheToken(token, loginDetails);
			return UserDTO.builder().idUser(loginDetails.getIdUser()).token(token).build();
		}
		return null;

	}

	/**
	 * Authorize.
	 *
	 * @param token the token
	 * @return the login DTO
	 */
	@Override
	public LoginDTO authorize(String token) {
		LoginDTO loginDTO = cache.get(token);
		if (null != loginDTO) {
			return loginDTO;
		}
		// TO-DO throw exception from here
		return null;
	}

	/**
	 * Cache token.
	 *
	 * @param token        the token
	 * @param loginDetails the login details
	 */
	private void cacheToken(String token, LoginDTO loginDetails) {
		cache.put(token, loginDetails);
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
			String token = new StringBuilder().append(loginDetails.getIdUser()).append(" ")
					.append(loginDetails.getIdRole()).append(" ").append(loginDetails.getRoleDescription()).toString();
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
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(token.getBytes());
			return new String(encrypted);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TO-DO throw Exception
		}
		return token;

	}

	/**
	 * Decrypt token.
	 *
	 * @param token the token
	 * @return the string
	 */
	public String decryptToken(String token) {
		try {
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			return new String(cipher.doFinal(token.getBytes()));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TO-DO throw Exception
		}
		return token;
	}

}
