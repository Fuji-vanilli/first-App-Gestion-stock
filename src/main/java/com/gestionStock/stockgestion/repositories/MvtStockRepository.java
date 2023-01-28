package com.gestionServer.gestionServer.repositories;

import com.gestionServer.gestionServer.models.MvtStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvtStockRepository extends JpaRepository<MvtStock, Integer> {
}
