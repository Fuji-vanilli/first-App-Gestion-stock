package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.MvtStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvtStockRepository extends JpaRepository<MvtStock, Integer> {
}
