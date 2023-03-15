package com.gestionStock.stockgestion.DTOs.request;


import com.gestionStock.stockgestion.DTOs.response.AdressResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntrepriseRequest {

    private String name;

    private String description;

    private AdressResponse adress;

    private String codeFiscal;

    private String email;

    private String tel;

    private String site;

    private List<UserResponse> users;




}
