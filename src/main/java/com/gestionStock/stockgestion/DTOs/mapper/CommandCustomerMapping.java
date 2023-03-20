package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.CommandCustomerRequest;
import com.gestionStock.stockgestion.DTOs.response.CommandCustomerResponse;
import com.gestionStock.stockgestion.models.CommandCustomer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandCustomerMapping {
    CommandCustomer commandCustomerRequestToCommandCustomer(CommandCustomerRequest commandCustomerRequest);
    CommandCustomerResponse commandCustomerToCommandCustomerResposnse(CommandCustomer commandCustomer);
}
