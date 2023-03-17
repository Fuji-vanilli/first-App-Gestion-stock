package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.ProviderRequest;
import com.gestionStock.stockgestion.DTOs.response.ProviderResponse;
import com.gestionStock.stockgestion.models.Provider;

import java.util.List;

public interface ProviderService {
    ProviderResponse create(ProviderRequest providerRequest);
    ProviderResponse getById(String id);
    ProviderResponse getByEmail(String email);
    List<ProviderResponse> getAll();
    boolean delete(String id);
}