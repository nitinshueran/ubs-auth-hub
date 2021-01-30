package com.ubs.auth.hub.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	/** The id user. */
	private Integer idUser;

	/** The token. */
	private String token;

}
