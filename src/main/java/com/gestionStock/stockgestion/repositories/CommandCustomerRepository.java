package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.models.CommandCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandCustomerRepository extends JpaRepository<CommandCustomer, String> {
}
