package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
}
