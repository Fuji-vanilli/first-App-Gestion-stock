package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.EntrepriseDTO;

import java.util.List;

public interface IEntrepriseService {

    EntrepriseDTO create(EntrepriseDTO entrepriseDTO);
    EntrepriseDTO getById(Integer id);
    EntrepriseDTO getByName(String name);
    List<EntrepriseDTO> getAll();
    boolean delete(Integer id);
}
