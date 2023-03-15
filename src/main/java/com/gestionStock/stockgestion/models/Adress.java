package com.gestionStock.stockgestion.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Embeddable
public class Adress extends AbstractEntity{

    private String adress1;

    private String adress2;

    private String city;

    private int codePostal;

    private String country;
}
