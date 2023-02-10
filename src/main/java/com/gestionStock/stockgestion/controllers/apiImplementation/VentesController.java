package com.gestionStock.stockgestion.controllers.apiImplementation;

import com.gestionStock.stockgestion.DTOs.VenteDTO;
import com.gestionStock.stockgestion.controllers.api.VenteApi;
import com.gestionStock.stockgestion.services.servicesImplementation.VenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VentesController implements VenteApi {

    private final VenteService venteService;

    @Override
    public VenteDTO create(VenteDTO venteDTO) {
        return venteService.create(venteDTO);
    }

    @Override
    public VenteDTO getById(Integer id) {
        return venteService.getById(id);
    }

    @Override
    public VenteDTO getByCode(String code) {
        return venteService.getByCode(code);
    }

    @Override
    public List<VenteDTO> getAll() {
        return venteService.getAll();
    }

    @Override
    public boolean delete(Integer id) {
        return venteService.delete(id);
    }
}
