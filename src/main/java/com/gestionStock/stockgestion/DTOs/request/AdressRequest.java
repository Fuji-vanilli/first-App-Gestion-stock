package com.gestionStock.stockgestion.DTOs.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdressRequest {

    private String adress1;

    private String adress2;

    private String city;

    private String codePostale;

    private String country;

}
