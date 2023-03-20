package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.CommandCustomerRequest;
import com.gestionStock.stockgestion.DTOs.response.CommandCustomerResponse;
import com.gestionStock.stockgestion.models.CommandCustomer;

import java.util.List;

public interface CommandCustomerService {
    CommandCustomerResponse create(CommandCustomerRequest commandCustomerRequest);
    CommandCustomerResponse findById(String id);
    CommandCustomerResponse findByCode(String code);
    List<CommandCustomerResponse> getAll();
    boolean delete(String id);
}
