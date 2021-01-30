package com.ubs.auth.hub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "idRole")
	private Integer idRole;


	/** The roleDescription. */
	@Column(name = "roleDescription")
	private String roleDescription;

}

