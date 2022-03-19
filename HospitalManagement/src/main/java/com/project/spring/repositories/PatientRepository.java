package com.project.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.spring.entites.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Patient findByNom(String name);
}
