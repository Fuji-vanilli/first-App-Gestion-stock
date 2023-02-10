package com.gestionStock.stockgestion.repositories;


import com.gestionStock.stockgestion.models.CommandClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandClientRepository extends JpaRepository<CommandClient, Integer> {

    Optional<CommandClient> findByReference(String code);
}
