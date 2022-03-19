package com.project.spring.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.spring.entites.Consultation;
import com.project.spring.entites.Medecin;
import com.project.spring.entites.Patient;
import com.project.spring.entites.RendezVous;
import com.project.spring.repositories.ConsultationRepository;
import com.project.spring.repositories.MedecinRepository;
import com.project.spring.repositories.PatientRepository;
import com.project.spring.repositories.RendezVousRepository;

@Service
@Transactional // execute all of methode
public class hospitalServiceImp implements IHospitalService {
	// Dependencey injection use annotation @autowaird OR Constractor
	private PatientRepository patientRepository; 
	private MedecinRepository medecinRepository;
	private RendezVousRepository rendezVousRepository;
	private ConsultationRepository consultationRepository;

	public hospitalServiceImp(PatientRepository patientRepository, MedecinRepository medecinRepository,
			RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
		super();
		this.patientRepository = patientRepository;
		this.medecinRepository = medecinRepository;
		this.rendezVousRepository = rendezVousRepository;
		this.consultationRepository = consultationRepository;
	}

	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public Medecin saveMedecin(Medecin medecin) {
		// TODO Auto-generated method stub
		return medecinRepository.save(medecin);
	}

	@Override
	public RendezVous saveRendezVous(RendezVous rendezVous) {
		// TODO Auto-generated method stub
		return rendezVousRepository.save(rendezVous);
	}

	@Override
	public Consultation saveConsultation(Consultation consultation) {
		// TODO Auto-generated method stub
		return consultationRepository.save(consultation);
	}

}
