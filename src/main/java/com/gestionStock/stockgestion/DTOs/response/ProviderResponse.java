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
public class ProviderResponse {

    private String id;

    private String name;

    private AdressResponse adress;

    private String picture;

    private String email;

    private String tel;

    private List<CommandProviderResponse> commandFournisseurs;

}
