package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.CommandClientDTO;

import java.util.List;

public interface ICommandClientService {

    CommandClientDTO create(CommandClientDTO commandClientDTO);
    CommandClientDTO getById(Integer id);
    CommandClientDTO getByReference(String reference);
    List<CommandClientDTO> getAll();
    boolean delete(Integer id);
}
