package com.project.spring;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.spring.entites.Consultation;
import com.project.spring.entites.Medecin;
import com.project.spring.entites.Patient;
import com.project.spring.entites.RendezVous;
import com.project.spring.entites.StatusRDV;
import com.project.spring.repositories.ConsultationRepository;
import com.project.spring.repositories.MedecinRepository;
import com.project.spring.repositories.PatientRepository;
import com.project.spring.repositories.RendezVousRepository;
import com.project.spring.service.IHospitalService;
import com.project.spring.service.hospitalServiceImp;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.bytebuddy.implementation.bytecode.Throw;

@SpringBootApplication
public class HospitalManagementApplication extends Exception {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
		return args -> {
			Stream.of("Mohammed", "Najat", "Kenza").forEach(name -> {
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(false);
				patient.setRendezVous(null);
				hospitalService.savePatient(patient);
			});
			Stream.of("Salma", "Anass", "Ayoub").forEach(name -> {
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setSepecialite(Math.random() > 0.5 ? "cardio" : "Dentiste");

				medecin.setEmail(name + "@gmail.com");
				hospitalService.saveMedecin(medecin);
			});
			Patient patient1 = patientRepository.findById(1L).orElse(null);
			Patient patient = patientRepository.findByNom("Najat");

			Medecin medecin = medecinRepository.findById(2L).orElse(null);
			Medecin medecin2 = medecinRepository.findBynom("Ayoub");
			
			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new  Date());
			rendezVous.setStatus(StatusRDV.DONE);
			rendezVous.setMedecin(medecin2);
			rendezVous.setPatient(patient1);
			hospitalService.saveRendezVous(rendezVous);
		//	rendezVousRepository.save(rendezVous);
			
			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation = new Consultation();
			consultation.setDateConsultaion(rendezVous1.getDate());
			consultation.setRapport("Vous avez un probleme au niveau de cerveau ");
			consultation.setRendezVous(rendezVous1);
			hospitalService.saveConsultation(consultation);
			//	consultationRepository.save(consultation);
			
			
		
		};

	};

}
