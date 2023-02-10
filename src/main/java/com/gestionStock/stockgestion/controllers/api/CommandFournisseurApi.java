package com.gestionStock.stockgestion.controllers.api;

import com.gestionStock.stockgestion.DTOs.CommandFournisseurDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.print.attribute.standard.Media;
import java.util.List;

import static com.gestionStock.stockgestion.utils.Constants.APP_ROOT;

public interface CommandFournisseurApi {
    @PostMapping(value = APP_ROOT+ "commandFournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandFournisseurDTO create(@PathVariable CommandFournisseurDTO commandFournisseurDTO);

    @GetMapping(value = APP_ROOT+ "commandFournisseur/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandFournisseurDTO getById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+ "commandFournisseur/get/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandFournisseurDTO getByCode(@PathVariable String code);

    @GetMapping(value = APP_ROOT+ "commandFournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandFournisseurDTO> getAll();

    @DeleteMapping(value = APP_ROOT+ "commandFournisseur/delete/{id}")
    boolean delete(@PathVariable Integer id);
}
