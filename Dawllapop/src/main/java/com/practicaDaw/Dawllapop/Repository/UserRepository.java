package com.practicaDaw.Dawllapop.Repository;

import java.util.Date;
import java.util.List;
import com.practicaDaw.Dawllapop.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByName(String name);
	
	//By the time the query just shows 4 users because the view only can load 4
	@Query(value = "SELECT * FROM user WHERE UPPER(name) LIKE CONCAT('%', CONCAT(UPPER(:name), '%')) LIMIT 4", nativeQuery = true)
	List<User> searchByName(@Param("name") String name);



}