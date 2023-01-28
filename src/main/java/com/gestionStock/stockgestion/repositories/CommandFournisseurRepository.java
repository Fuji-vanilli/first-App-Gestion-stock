package com.gestionServer.gestionServer.repositories;

import com.gestionServer.gestionServer.models.CommandFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandFournisseurRepository extends JpaRepository<CommandFournisseur, Integer> {
}
