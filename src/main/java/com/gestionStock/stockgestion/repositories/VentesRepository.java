package com.gestionServer.gestionServer.repositories;

import com.gestionServer.gestionServer.models.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentesRepository extends JpaRepository<Ventes, Integer> {
}
