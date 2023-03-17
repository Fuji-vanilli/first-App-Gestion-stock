package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.CustomerRequest;
import com.gestionStock.stockgestion.DTOs.response.CustomerResponse;
import com.gestionStock.stockgestion.models.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapping {
    CustomerResponse customerToCustomerResponse(Customer customer);
    Customer customerRequestToCustomer(CustomerRequest customerRequest);
}
