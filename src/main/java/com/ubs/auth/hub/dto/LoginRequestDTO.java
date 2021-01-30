package com.ubs.auth.hub.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The Class LoginRequestDTO takes in username and password of user.
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

	/** The username. */
	private String username;

	/** The password. */
	private String password;

}