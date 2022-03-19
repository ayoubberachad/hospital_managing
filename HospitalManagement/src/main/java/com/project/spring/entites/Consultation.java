package com.project.spring.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Consultation {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private Date dateConsultaion ;
	private String rapport ;
	@OneToOne 
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private RendezVous rendezVous;
	
	

}
