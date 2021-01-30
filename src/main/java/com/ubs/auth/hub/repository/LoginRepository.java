package com.ubs.auth.hub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ubs.auth.hub.entity.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface LoginRepository extends CrudRepository<User, Integer> {

	/**
	 * Find by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the optional
	 */
	User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
