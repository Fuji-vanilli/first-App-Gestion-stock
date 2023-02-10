package com.gestionStock.stockgestion.controllers.api;

import com.gestionStock.stockgestion.DTOs.ClientDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestionStock.stockgestion.utils.Constants.APP_ROOT;

public interface ClientApi {

    @PostMapping(value = APP_ROOT+ "client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO create(@RequestBody ClientDTO clientDTO);

    @GetMapping(value = APP_ROOT+ "client/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO getById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+ "client/get/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO getByFirstName(@PathVariable String firstName);

    @GetMapping(value = APP_ROOT+ "client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDTO> getAll();

    @DeleteMapping(value = APP_ROOT+ "client/{id}")
    boolean delete(@PathVariable Integer id);
}
