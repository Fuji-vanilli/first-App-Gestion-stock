package com.gestionStock.stockgestion.DTOs.request;


import com.gestionStock.stockgestion.DTOs.response.AdressResponse;
import com.gestionStock.stockgestion.DTOs.response.CommandCustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private String firstName;

    private String lastName;

    private AdressResponse adress;

    private String picture;

    private String email;

    private String tel;

    private List<CommandCustomerResponse> commandClient;

}
