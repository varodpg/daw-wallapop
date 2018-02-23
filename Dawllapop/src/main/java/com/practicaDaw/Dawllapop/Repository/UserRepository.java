package com.practicaDaw.Dawllapop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicaDaw.Dawllapop.Entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByName(String name);
	//User findUser(long id);
}
