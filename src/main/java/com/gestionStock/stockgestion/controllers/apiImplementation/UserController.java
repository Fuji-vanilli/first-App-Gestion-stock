package com.gestionStock.stockgestion.controllers.apiImplementation;

import com.gestionStock.stockgestion.DTOs.UserDTO;
import com.gestionStock.stockgestion.controllers.api.UserApi;
import com.gestionStock.stockgestion.services.servicesImplementation.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public UserDTO create(UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @Override
    public UserDTO getById(Integer id) {
        return userService.getById(id);
    }

    @Override
    public UserDTO getByFirstName(String firstName) {
        return userService.getByFirstName(firstName);
    }

    @Override
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @Override
    public boolean delete(Integer id) {
        return userService.delete(id);
    }
}
