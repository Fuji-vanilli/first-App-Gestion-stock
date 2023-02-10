package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.CommandFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandFournisseurRepository extends JpaRepository<CommandFournisseur, Integer> {
    Optional<CommandFournisseur> findByCode(String code);
}
