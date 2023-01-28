package com.gestionServer.gestionServer.repositories;

import com.gestionServer.gestionServer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
