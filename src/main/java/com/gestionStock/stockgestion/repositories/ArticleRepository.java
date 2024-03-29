package com.gestionStock.stockgestion.repositories;

import com.gestionStock.stockgestion.models.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Articles, String> {
    Optional<Articles> findByCodeArticle(String code);
}
