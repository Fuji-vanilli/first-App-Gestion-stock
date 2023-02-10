package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.CommandClientDTO;
import com.gestionStock.stockgestion.DTOs.CommandFournisseurDTO;

import java.util.List;

public interface ICommandFournisseurService {
    CommandFournisseurDTO create(CommandFournisseurDTO commandFournisseurDTO);
    CommandFournisseurDTO getById(Integer id);
    CommandFournisseurDTO getByCode(String code);
    List<CommandFournisseurDTO> getAll();
    boolean delete(Integer id);
}
