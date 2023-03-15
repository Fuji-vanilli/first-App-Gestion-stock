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
public class CommandCustomerResponse {

    private String id;

    private String code;

    private Instant dateCommande;

    private CustomerResponse customer;

    private List<LineCommandCustomerResponse> ligneCommandCustomer;

}
