package com.gestionStock.stockgestion.DTOs.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommandProviderResponse{

    private String id;

    private String code;

    private Instant dateCommand;

    private ProviderResponse fournisseur;

    private List<LineCommandProviderResponse > lineCommandProviderResponse;

}
