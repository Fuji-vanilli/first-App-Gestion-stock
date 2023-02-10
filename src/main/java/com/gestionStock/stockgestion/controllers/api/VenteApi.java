package com.gestionStock.stockgestion.controllers.api;

import com.gestionStock.stockgestion.DTOs.VenteDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestionStock.stockgestion.utils.Constants.APP_ROOT;

public interface VenteApi {
    @PostMapping(value = APP_ROOT+ "ventes/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDTO create(@RequestBody VenteDTO venteDTO);
    @GetMapping(value = APP_ROOT+ "ventes/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDTO getById(@PathVariable Integer id);
    @GetMapping(value = APP_ROOT+ "ventes/get/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDTO getByCode(@PathVariable String code);
    @GetMapping(value = APP_ROOT+ "ventes/all")
    List<VenteDTO> getAll();
    @DeleteMapping(value = APP_ROOT+ "ventes/delete/{id}")
    boolean delete(Integer id);
}
