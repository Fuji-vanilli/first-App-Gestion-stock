package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentesRepository extends JpaRepository<Ventes, Integer> {
    Optional<Ventes> findByCode(String code);
}
