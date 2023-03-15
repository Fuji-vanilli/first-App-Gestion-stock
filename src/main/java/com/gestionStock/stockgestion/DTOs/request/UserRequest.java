package com.gestionStock.stockgestion.DTOs.request;

import com.gestionStock.stockgestion.DTOs.response.AdressResponse;
import com.gestionStock.stockgestion.DTOs.response.EntrepriseResponse;
import com.gestionStock.stockgestion.DTOs.response.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private Instant dateOfBirth;

    private AdressResponse adress;

    private String picture;

    private EntrepriseResponse entreprise;

    private List<RoleResponse> roles;

}
