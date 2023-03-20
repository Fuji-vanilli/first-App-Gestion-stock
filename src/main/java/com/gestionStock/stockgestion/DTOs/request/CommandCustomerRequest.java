package com.gestionStock.stockgestion.DTOs.request;

import com.gestionStock.stockgestion.DTOs.response.CustomerResponse;
import com.gestionStock.stockgestion.DTOs.response.LineCommandCustomerResponse;
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

    private String code;

    private CustomerResponse customer;

    private List<LineCommandCustomerRequest> ligneCommandCustomer;

}
