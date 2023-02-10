package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.FournisseurDTO;
import com.gestionStock.stockgestion.validators.FournisseurValidator;

import java.util.List;

public interface IFournisseurService {

    FournisseurDTO create(FournisseurDTO fournisseurDTO);
    FournisseurDTO getById(Integer id);
    FournisseurDTO getByFirstName(String firstName);
    List<FournisseurDTO> getAll();
    boolean delete(Integer id);
}
