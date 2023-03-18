package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.RoleRequest;
import com.gestionStock.stockgestion.DTOs.response.RoleResponse;

public interface RoleService {
    RoleResponse create(RoleRequest roleRequest);
}
