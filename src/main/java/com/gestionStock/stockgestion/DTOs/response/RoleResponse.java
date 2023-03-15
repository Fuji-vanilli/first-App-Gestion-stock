package com.gestionStock.stockgestion.DTOs.response;

import com.gestionStock.stockgestion.models.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {

    private Integer id;

    private String name;

    private UserResponse user;
}
