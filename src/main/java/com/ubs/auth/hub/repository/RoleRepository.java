package com.ubs.auth.hub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ubs.auth.hub.entity.Role;

/**
 * The Interface UserRepository.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {


}
