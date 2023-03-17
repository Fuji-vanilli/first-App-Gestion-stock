package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.ProviderRequest;
import com.gestionStock.stockgestion.DTOs.response.ProviderResponse;
import com.gestionStock.stockgestion.models.Provider;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProviderMapping {

    Provider providerRequestToProvider(ProviderRequest providerRequest);
    ProviderResponse providerToProviderRepsonse(Provider provider);
}
