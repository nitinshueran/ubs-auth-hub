package com.ubs.auth.hub.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

	/** The id user. */
	private Integer idUser;

	/** The username. */
	private String username;

	private String password;

	private Integer idRole;

}
