package com.gestionStock.stockgestion.controllers.api;

import com.gestionStock.stockgestion.DTOs.FournisseurDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestionStock.stockgestion.utils.Constants.APP_ROOT;

public interface FournisseurApi {

    @PostMapping(value = APP_ROOT+ "fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDTO create(@RequestBody FournisseurDTO fournisseurDTO);

    @GetMapping(value = APP_ROOT+ "fournisseur/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDTO getById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+ "fournisseur/get/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDTO getByFirstName(@PathVariable String firstName);

    @GetMapping(value = APP_ROOT+ "fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDTO> getAll();

    @DeleteMapping(value = "fournisseur/delete/{id}")
    boolean delete(@PathVariable Integer id);
}
