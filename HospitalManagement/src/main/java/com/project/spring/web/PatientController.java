package com.project.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spring.entites.Patient;
import com.project.spring.repositories.PatientRepository;

@RestController
public class PatientController {
@Autowired
	private PatientRepository patientRepository;
@GetMapping("/patients")
public List<Patient> patientList(){
	return patientRepository.findAll();
}
	
	
}
