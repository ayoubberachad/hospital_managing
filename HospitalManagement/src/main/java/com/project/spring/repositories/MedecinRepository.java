package com.project.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.spring.entites.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
Medecin findBynom(String name);
}
