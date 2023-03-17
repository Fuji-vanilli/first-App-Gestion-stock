package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.models.LineSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineSaleRepository extends JpaRepository<LineSale, String> {
}
