package com.practicaDaw.Dawllapop.security;

import org.springframework.data.repository.CrudRepository;

import com.practicaDaw.Dawllapop.Entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

		User findByName(String name);
}
