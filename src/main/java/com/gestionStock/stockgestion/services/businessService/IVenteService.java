package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.VenteDTO;

import java.util.List;

public interface IVenteService {

    VenteDTO create(VenteDTO venteDTO);
    VenteDTO getById(Integer id);
    VenteDTO getByCode(String code);
    List<VenteDTO> getAll();
    boolean delete(Integer id);
}
