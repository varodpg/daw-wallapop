package com.practicaDaw.Dawllapop.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Product;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
	List<Assessment> findAll();
}
