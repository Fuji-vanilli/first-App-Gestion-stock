package com.gestionServer.gestionServer.repositories;

import com.gestionServer.gestionServer.models.LigneCommandFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandFournisseurRepository extends JpaRepository<LigneCommandFournisseur, Integer> {
}
