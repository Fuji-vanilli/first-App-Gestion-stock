package com.gestionStock.stockgestion.services.businessService;

import com.gestionStock.stockgestion.DTOs.RolesDTO;
import com.gestionStock.stockgestion.models.Roles;

import java.util.List;

public interface IRolesService {
    RolesDTO create(RolesDTO rolesDTO);
    RolesDTO getById(Integer id);
    RolesDTO getByName(String name);
    List<RolesDTO> getAll();
    boolean delete(Integer id);
}