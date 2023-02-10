package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.LigneCommandFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandFournisseurRepository extends JpaRepository<LigneCommandFournisseur, Integer> {
}
