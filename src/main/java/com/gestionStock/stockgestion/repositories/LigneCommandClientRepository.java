package com.gestionServer.gestionServer.repositories;

import com.gestionServer.gestionServer.models.LigneCommandClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandClientRepository extends JpaRepository<LigneCommandClient, Integer> {
}
