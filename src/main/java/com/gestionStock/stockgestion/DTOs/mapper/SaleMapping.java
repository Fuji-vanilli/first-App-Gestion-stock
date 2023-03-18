package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.SaleRequest;
import com.gestionStock.stockgestion.DTOs.response.SaleResponse;
import com.gestionStock.stockgestion.models.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapping {
    Sale saleRequestToSale(SaleRequest saleRequest);
    SaleResponse saleToSaleResponse(Sale sale);
}
