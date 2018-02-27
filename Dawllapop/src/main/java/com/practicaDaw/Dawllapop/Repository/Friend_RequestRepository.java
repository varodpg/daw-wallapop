package com.practicaDaw.Dawllapop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practicaDaw.Dawllapop.Entities.Friend_request;
import com.practicaDaw.Dawllapop.Entities.User;

public interface Friend_RequestRepository extends JpaRepository<Friend_request,Long>{
	
	@Query(value = "SELECT * FROM friend_request WHERE TO_ID = :user AND state = 'pending'", nativeQuery = true)
	List<Friend_request> getUserRequests(@Param("user") User user);
	@Query(value = "SELECT * FROM user WHERE id IN (SELECT FROM_ID FROM friend_request WHERE TO_ID = :user AND state = 'accepted')", nativeQuery = true)
	List<User> getUserFriends(@Param("user") User user);
}
