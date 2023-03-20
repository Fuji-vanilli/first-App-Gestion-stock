package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.LineCommandCustomerRequest;
import com.gestionStock.stockgestion.DTOs.response.LineCommandCustomerResponse;
import com.gestionStock.stockgestion.models.LineCommandCustomer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LineCommandCustomerMapping {
    LineCommandCustomer lineCustomerRequestToLineCustomer(LineCommandCustomerRequest lineCommandCustomerRequest);
    LineCommandCustomerResponse lineCustomerToLineCustomerResponse(LineCommandCustomer lineCommandCustomer);
}
