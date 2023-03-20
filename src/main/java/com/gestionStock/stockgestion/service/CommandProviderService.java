package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.CommandProviderRequest;
import com.gestionStock.stockgestion.DTOs.response.CommandProviderResponse;

import java.util.List;

public interface CommandProviderService {
    CommandProviderResponse create(CommandProviderRequest commandProviderRequest);
    CommandProviderResponse getById(String id);
    CommandProviderResponse getByCode(String code);
    List<CommandProviderResponse> getAll();
    boolean delete(String id);
}
