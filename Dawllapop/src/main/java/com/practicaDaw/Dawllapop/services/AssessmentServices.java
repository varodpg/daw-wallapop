package com.practicaDaw.Dawllapop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;

@Service
public class AssessmentServices {
	@Autowired
	private AssessmentRepository assessmentRepository;

	public List<Assessment> getAllAssessment() {
		return assessmentRepository.findAll();
	}
	
	public Page<Assessment> getUserAssessments(User userTo, Pageable pageable){
		return assessmentRepository.findByUserTo(userTo, pageable);
	}
	
	
}
