package com.ubs.auth.hub.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	private Integer idItem;

	@ManyToOne()
	@JoinColumn(name = "idRole", nullable = false)
	private Integer idRole;

	/** The roleDescription. */
	private String roleDescription;

}
