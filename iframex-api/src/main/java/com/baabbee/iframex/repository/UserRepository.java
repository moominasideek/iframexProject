package com.baabbee.iframex.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.baabbee.iframex.beans.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByEmailId(String username);

}
