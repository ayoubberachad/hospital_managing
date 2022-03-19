package com.project.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.spring.entites.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{}
