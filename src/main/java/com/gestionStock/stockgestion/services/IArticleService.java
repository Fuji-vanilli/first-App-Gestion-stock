package com.gestionServer.gestionServer.services;

import com.gestionServer.gestionServer.DTOs.ArticleDTO;

import java.util.List;

public interface IArticleService {

    ArticleDTO getById(Integer id);
    ArticleDTO getByCode(String code);
    ArticleDTO save(ArticleDTO articleDTO);
    List<ArticleDTO> getAll();
    boolean delete(Integer id);

}
