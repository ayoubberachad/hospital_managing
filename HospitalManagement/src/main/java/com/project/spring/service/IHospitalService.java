package com.project.spring.service;

import com.project.spring.entites.Consultation;
import com.project.spring.entites.Medecin;
import com.project.spring.entites.Patient;
import com.project.spring.entites.RendezVous;

public interface IHospitalService {

		Patient savePatient(Patient patient);
		Medecin saveMedecin(Medecin medecin);
		RendezVous saveRendezVous(RendezVous rendezVous);
		Consultation saveConsultation(Consultation consultation);
		
		
}
