package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.EntrepriseRequest;
import com.gestionStock.stockgestion.DTOs.response.EntrepriseResponse;

import java.util.List;

public interface EntrepriseService {
    EntrepriseResponse create(EntrepriseRequest entrepriseRequest);
    EntrepriseResponse getById(String id);
    EntrepriseResponse getByCode(String code);
    List<EntrepriseResponse> getAll();
    boolean delete(String id);
}
