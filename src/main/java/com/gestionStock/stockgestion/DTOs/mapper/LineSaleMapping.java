package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.LineSaleRequest;
import com.gestionStock.stockgestion.DTOs.response.LineSaleResponse;
import com.gestionStock.stockgestion.models.LineSale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LineSaleMapping {
    LineSaleResponse lineSaleToLineSaleResponse(LineSale lineSale);
    LineSale lineSaleRequestToLineSale(LineSaleRequest lineSaleRequest);
}
