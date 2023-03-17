package com.gestionStock.stockgestion.service;

import com.gestionStock.stockgestion.DTOs.request.CustomerRequest;
import com.gestionStock.stockgestion.DTOs.response.CustomerResponse;
import com.gestionStock.stockgestion.models.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponse create(CustomerRequest customerRequest);
    CustomerResponse getById(String id);
    CustomerResponse getByEmail(String email);
    List<CustomerResponse> getAll();
    boolean delete(String id);
}
