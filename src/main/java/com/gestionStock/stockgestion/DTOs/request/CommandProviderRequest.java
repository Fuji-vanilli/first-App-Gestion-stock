package com.gestionStock.stockgestion.DTOs.request;


import com.gestionStock.stockgestion.DTOs.response.LineCommandProviderResponse;
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
public class CommandProviderRequest{

    private String code;

    private ProviderResponse fournisseur;

    private List<LineCommandProviderResponse> lineCommandProviderResponse;

}
