package com.gestionStock.stockgestion.DTOs.response;

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
public class UserResponse {

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
