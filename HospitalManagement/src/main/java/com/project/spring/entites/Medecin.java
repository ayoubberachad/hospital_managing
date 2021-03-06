package com.project.spring.entites;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Medecin {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	 private Long id;
	 private String nom; 
	 private String email ;
	 private String sepecialite;
	 @OneToMany(mappedBy="medecin",fetch =FetchType.LAZY )
	 @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	 private Collection<RendezVous> rendezVous;
	 
}
