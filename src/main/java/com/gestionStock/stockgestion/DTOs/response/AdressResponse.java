package com.gestionStock.stockgestion.DTOs.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdressResponse {

    private String id;

    private String adress1;

    private String adress2;

    private String city;

    private String codePostale;

    private String country;

}
