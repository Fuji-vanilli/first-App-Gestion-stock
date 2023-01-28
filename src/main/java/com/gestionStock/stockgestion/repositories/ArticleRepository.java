package com.gestionServer.gestionServer.repositories;

import com.gestionServer.gestionServer.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findByArticleByCode(String code);
}
