package com.gestionStock.stockgestion.DTOs.request;

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
public class CommandCustomerRequest {

    private CustomerResponse customer;

    private List<LineCommandCustomerResponse> ligneCommandCustomer;

}
