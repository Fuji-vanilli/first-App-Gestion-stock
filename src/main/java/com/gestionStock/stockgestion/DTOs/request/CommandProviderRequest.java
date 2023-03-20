package com.gestionStock.stockgestion.DTOs.request;


import com.gestionStock.stockgestion.DTOs.response.LineCommandProviderResponse;
import com.gestionStock.stockgestion.DTOs.response.ProviderResponse;
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

    private ProviderResponse provider;

    private List<LineCommandProviderRequest> lineCommandProviderRequest;

}
