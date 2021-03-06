package com.practicaDaw.Dawllapop.ApiRestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.Repository.AssessmentRepository;
import com.practicaDaw.Dawllapop.Repository.UserRepository;
import com.practicaDaw.Dawllapop.security.UserComponent;
import com.practicaDaw.Dawllapop.services.AssessmentServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/assessments")
public class RestAssessment {
	@Autowired
	private UserComponent userComponent;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AssessmentRepository assessmentRepo;
	
	@Autowired
	private AssessmentServices assessmentServices;
	
	//Method that adds an assessment to a user
	@JsonView(Assessment.BasicInformation.class)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Assessment> addAssessment(@RequestBody Map<String, Object> rBody){
		User userLogged = userComponent.getLoggedUser();
		User userTo = userRepo.findById((int) rBody.get("idUser"));
		Assessment assessment = new Assessment((String) rBody.get("message"), (int) rBody.get("value"), userLogged, userTo, new Date());
		assessmentRepo.save(assessment);
		return new ResponseEntity<>(assessment, HttpStatus.OK);		
	}
	
	
	//Method that gets all the user assessments
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Assessment>> getUserAsessments(@PathVariable long id){
		User user = userRepo.findById(id);
		List<Assessment> assessments = assessmentServices.getUserAssessmentsNoPageable(user);
		return new ResponseEntity<>(assessments, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Assessment>> getAllAssessment(){
		List<Assessment> assessments = assessmentServices.getAllAssessment();
		if(!assessments.isEmpty()) {
			return new ResponseEntity(assessments, HttpStatus.OK);
		} else{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteAssessment(@PathVariable long id){
		Assessment assessment = assessmentRepo.findOne(id);
		if(assessment != null) {
			assessmentRepo.delete(assessment);
			return new ResponseEntity(HttpStatus.OK);
		} else{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
