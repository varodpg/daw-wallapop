package com.practicaDaw.Dawllapop.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.User;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
	List<Assessment> findAll();
	@Query(value = "SELECT * FROM assessment WHERE USER_TO_ID = :userTo /*#pageable*/",
			countQuery = "SELECT * FROM assessment WHERE USER_TO_ID = :userTo /*#pageable*/",
			nativeQuery = true)
	Page<Assessment> findByUserTo(@Param("userTo") User userTo, Pageable pageable);
}
