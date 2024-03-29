package com.gestionStock.stockgestion.DTOs.request;

import com.gestionStock.stockgestion.DTOs.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {

    private String name;

    private UserResponse user;
}
