package com.gestionStock.stockgestion.controllers.api;

import com.gestionStock.stockgestion.DTOs.CommandClientDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestionStock.stockgestion.utils.Constants.APP_ROOT;

public interface CommandClientApi {
    @PostMapping(value = APP_ROOT+ "commandClient/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CommandClientDTO create(@RequestBody CommandClientDTO commandClientDTO);

    @GetMapping(value = APP_ROOT+ "commandClient/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandClientDTO getById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+ "commandClient/get/{reference}", produces = MediaType.APPLICATION_JSON_VALUE)
    CommandClientDTO getByReference(@PathVariable String reference);

    @GetMapping(value = APP_ROOT+ "commandClient/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandClientDTO> getAll();

    @DeleteMapping(value = APP_ROOT+ "commandClient/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    boolean delete(@PathVariable Integer id);
}
