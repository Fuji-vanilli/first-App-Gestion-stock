package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.ClientDTO;

import java.util.List;

public interface IClientService {

        ClientDTO create(ClientDTO clientDTO);
        ClientDTO getById(Integer id);
        ClientDTO getByFirstName(String firstName);
        List<ClientDTO> getAll();
        boolean delete(Integer id);
}
