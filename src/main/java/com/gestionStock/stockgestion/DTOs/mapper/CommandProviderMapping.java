package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.CommandProviderRequest;
import com.gestionStock.stockgestion.DTOs.response.CommandProviderResponse;
import com.gestionStock.stockgestion.models.CommandProvider;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandProviderMapping {
    CommandProvider commandProviderRequestToCommandProvider(CommandProviderRequest commandProviderRequest);
    CommandProviderResponse commandProviderToCommandProviderResponse(CommandProvider commandProvider);
}
