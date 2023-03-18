package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.SaleRequest;
import com.gestionStock.stockgestion.DTOs.response.SaleResponse;

import java.util.List;

public interface SaleService {
    SaleResponse create(SaleRequest saleRequest);
    SaleResponse getById(String id);
    List<SaleResponse> getAll();
    boolean delete(String id);
}
