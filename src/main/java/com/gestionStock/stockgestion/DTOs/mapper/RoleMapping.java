package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.RoleRequest;
import com.gestionStock.stockgestion.DTOs.response.RoleResponse;
import com.gestionStock.stockgestion.models.Roles;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapping {

    RoleResponse roleToRoleResponse(Roles role);
    Roles roleRequestToRole(RoleRequest roleRequest);
}
