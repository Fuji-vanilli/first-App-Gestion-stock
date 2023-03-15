package com.gestionStock.stockgestion.DTOs.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private String id;

    private String firstName;

    private String lastName;

    private AdressResponse adress;

    private String picture;

    private String email;

    private String tel;

    private List<CommandCustomerResponse> commandClient;

}
