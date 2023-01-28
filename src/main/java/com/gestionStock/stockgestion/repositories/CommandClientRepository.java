package com.gestionServer.gestionServer.repositories;

import com.gestionServer.gestionServer.models.CommandClient;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandClientRepository extends JpaRepository<CommandClient, Integer> {
}
