package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {

    Optional<Entreprise> findByCode(String code);
}
