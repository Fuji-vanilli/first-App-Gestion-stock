package com.gestionStock.stockgestion.DTOs.mapper;

import com.gestionStock.stockgestion.DTOs.request.EntrepriseRequest;
import com.gestionStock.stockgestion.DTOs.response.EntrepriseResponse;
import com.gestionStock.stockgestion.models.Entreprise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepriseMapping {
    Entreprise entrepriseRequestToEntreprise(EntrepriseRequest entrepriseRequest);
    EntrepriseResponse entrepriseToEntrepriseResponse(Entreprise entreprise);
}
