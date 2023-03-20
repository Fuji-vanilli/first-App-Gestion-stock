package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.LineCommandProviderRequest;
import com.gestionStock.stockgestion.DTOs.response.LineCommandProviderResponse;
import com.gestionStock.stockgestion.models.LineCommandProvider;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LineCommandProviderMapping {
    LineCommandProvider lineProviderRequestToLineProvider(LineCommandProviderRequest lineCommandProviderRequest);
    LineCommandProviderResponse lineProviderToLineProviderResponse(LineCommandProvider lineCommandProvider);
}
