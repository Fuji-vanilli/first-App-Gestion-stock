package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.Articles;
import com.gestionStock.stockgestion.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
