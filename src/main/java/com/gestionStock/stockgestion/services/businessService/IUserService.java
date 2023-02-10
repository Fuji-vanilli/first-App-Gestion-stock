package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO create(UserDTO userDTO);
    UserDTO getById(Integer id);
    UserDTO getByFirstName(String firstName);
    List<UserDTO> getAll();
    boolean delete(Integer id);

}
