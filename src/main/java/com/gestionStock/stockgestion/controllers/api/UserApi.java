package com.gestionStock.stockgestion.controllers.api;

import com.gestionStock.stockgestion.DTOs.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

import static com.gestionStock.stockgestion.utils.Constants.APP_ROOT;

public interface UserApi {
    @PostMapping(value = APP_ROOT+ "user/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO create(@RequestBody UserDTO userDTO);

    @GetMapping(value = APP_ROOT+ "user/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT+ "user/get/{firstName}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDTO getByFirstName(@PathVariable String firstName);

    @GetMapping(value = APP_ROOT+ "user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserDTO> getAll();

    @DeleteMapping(value = APP_ROOT+ "user/delete/{id}")
    boolean delete(@PathVariable Integer id);
}
