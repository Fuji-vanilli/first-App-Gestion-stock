package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.LigneCommandClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandClientRepository extends JpaRepository<LigneCommandClient, Integer> {
}
