package com.ubs.auth.hub.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubs.auth.hub.dto.LoginDTO;
import com.ubs.auth.hub.entity.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface LoginRepository extends CrudRepository<User, Integer> {

	@Query("select user.idUser, role.idRole, role.roleDescription from user user inner join role role where user.username='cecilia' and user.password='cecilia1' and user.idRole = role.idRole")
	public LoginDTO getLoginDetails(String username, String password);

}
