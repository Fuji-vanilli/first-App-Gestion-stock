package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.AdressRequest;
import com.gestionStock.stockgestion.DTOs.response.AdressResponse;
import com.gestionStock.stockgestion.models.Adress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdressMapper {

    Adress adressRequestToAdress(AdressRequest adressRequest);
    AdressResponse adressToAdressResponse(Adress adress);

}
